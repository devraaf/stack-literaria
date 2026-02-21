package com.devraaf.stackLiteraria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String idioma;

    private Integer numeroDownloads;

    public Livro(){}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        if (dadosLivro.idioma() != null && !dadosLivro.idioma().isEmpty()) {
            this.idioma = dadosLivro.idioma().get(0);
        }
        this.numeroDownloads = dadosLivro.numeroDownloads();

        if (dadosLivro.autor() != null && !dadosLivro.autor().isEmpty()) {

            DadosAutor dadosAutor = dadosLivro.autor().get(0);

            if (dadosAutor.nome() != null) {
                this.autor = new Autor(
                        dadosAutor.nome(),
                        dadosAutor.anoNascimento(),
                        dadosAutor.anoFalecimento()
                );
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return """
                ------------ LIVRO ------------
                Título: %s
                Autor: %s
                Idioma: %s
                Número de downloads: %d
                """.formatted(titulo, autor.getNome(), idioma, numeroDownloads);
    }
}
