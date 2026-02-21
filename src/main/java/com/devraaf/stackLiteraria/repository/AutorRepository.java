package com.devraaf.stackLiteraria.repository;

import com.devraaf.stackLiteraria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.anoFalecimento > :ano AND a.anoNascimento < :ano")
    List<Autor> autoresVivosDeterminadoAno(int ano);
}
