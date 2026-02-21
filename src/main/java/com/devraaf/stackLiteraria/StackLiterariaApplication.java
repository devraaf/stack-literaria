package com.devraaf.stackLiteraria;

import com.devraaf.stackLiteraria.main.Principal;
import com.devraaf.stackLiteraria.repository.AutorRepository;
import com.devraaf.stackLiteraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StackLiterariaApplication implements CommandLineRunner {
	@Autowired
	private LivroRepository repositorioLivros;
	@Autowired
	private AutorRepository repositorioAutores;


	public static void main(String[] args) {
		SpringApplication.run(StackLiterariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorioLivros, repositorioAutores);
		principal.exibeMenu();
	}
}
