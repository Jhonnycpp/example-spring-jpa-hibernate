package com.example.demo;

import java.util.ArrayList;
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
			List<Author> authors = new ArrayList<Author>();
			Author author = new Author();
			author.setName("Jhonatan");			
			authors.add(author);
			
			author = new Author();
			author.setName("Joao");
			authors.add(author);
			
			author = new Author();
			author.setName("Luis");
			authors.add(author);
			
			author = new Author();
			author.setName("Bia");
			authors.add(author);
			
			repository.saveAll(authors);
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
