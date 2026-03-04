package com.devraaf.stackLiteraria.main;

import com.devraaf.stackLiteraria.model.Autor;
import com.devraaf.stackLiteraria.model.DadosBusca;
import com.devraaf.stackLiteraria.model.DadosLivro;
import com.devraaf.stackLiteraria.model.Livro;
import com.devraaf.stackLiteraria.repository.AutorRepository;
import com.devraaf.stackLiteraria.repository.LivroRepository;
import com.devraaf.stackLiteraria.service.ConsumoApi;
import com.devraaf.stackLiteraria.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private String menu;
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private LivroRepository repositorioLivros;
    private AutorRepository repositorioAutores;
    private List<Autor> autores = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    public Principal(LivroRepository livroRepository,
                     AutorRepository autorRepository){
        this.repositorioLivros = livroRepository;
        this.repositorioAutores = autorRepository;
    }
    public void exibeMenu(){
        var opcao = -1;

        while (opcao != 0){
            menu = """
                \n
                    ==========================
                       CATÁLOGO DE LIVROS
                    ==========================
                1 - Buscar livros pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros em um determinado idioma
                
                0 - Sair
                
                Selecione uma opção: 
                """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    buscaLivroPeloTitulo();
                    break;
                case 2:
                    listaLivrosRegistrados();
                    break;
                case 3:
                    listaAutoresRegistrados();
                    break;
                case 4:
                    listaAutoresVivosPorAno();
                    break;
                case 5:
                    listaLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private DadosLivro pegaDadosLivro() {
        System.out.println("Digite o nome do livro para busca: ");
        var titulo = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + titulo.toLowerCase().replace(" ", "+"));
        DadosBusca busca = conversor.obterDados(json, DadosBusca.class);

        if (busca.results().isEmpty()) {
            System.out.println("Livro não encontrado!");
            return null;
        }
        return busca.results().get(0);
    }

    private void buscaLivroPeloTitulo() {
        DadosLivro dadosLivro = pegaDadosLivro();

        if (dadosLivro == null) {
            return;
        }
        Livro livro = new Livro(dadosLivro);
        repositorioLivros.save(livro);
        System.out.println(dadosLivro);
    }

    private void listaLivrosRegistrados() {
        livros = repositorioLivros.findAll();
        livros.forEach(System.out::println);
    }

    private void listaAutoresRegistrados() {
        autores = repositorioAutores.findAll();
        autores.forEach(System.out::println);
    }

    private void listaAutoresVivosPorAno() {
        System.out.println("Digite o ano para busca: ");
        int ano = leitura.nextInt();
        leitura.nextLine();
        List<Autor> autoresVivosPorAno = repositorioAutores.autoresVivosDeterminadoAno(ano);
        autoresVivosPorAno.forEach(System.out::println);
    }

    private void listaLivrosPorIdioma() {
        System.out.println("Escolha o idioma para busca: \n " +
                "[pt] [en] [fr] [es]");
        String idioma = leitura.nextLine();
        List<Livro> livrosPorIdioma = repositorioLivros.findByIdiomaContainingIgnoreCase(idioma);
        if (livrosPorIdioma.isEmpty()){
            System.out.println("Não há livros deste idioma cadastrados.");
        }else {
            livrosPorIdioma.forEach(System.out::println);
        }
    }
}
