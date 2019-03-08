package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
    AuthorRepository repository;
	
	@RequestMapping("/start")
	public String cargaInicial() {
		try {
			Author author = new Author();
			author.setName("Jhonatan");
			repository.save(author);
			
			author = new Author();
			author.setName("Joao");
			repository.save(author);
			
			author = new Author();
			author.setName("Luis");
			repository.save(author);
			
			author = new Author();
			author.setName("Bia");
			repository.save(author);
			return "Foi";
		}catch (Exception e) 
		{
			return "Nao foi!";
		}
	}
	
	@PostMapping("/add")
	public String add(@Valid @RequestBody Author author) {
		try {
			repository.save(author);
			return "Foi";
		}catch (Exception e) {
			return "Nao foi";
		}
	}
	
	@RequestMapping("/all")
	public List<Author> getAll()
	{
		return repository.findAll();
	}
}
