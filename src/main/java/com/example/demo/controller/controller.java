package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repo.*;
import com.example.demo.aws.*;

@RequestMapping("/users")
@RestController
public class controller {

	@Autowired
	repository repo;
	
	@PostMapping(path="/author",consumes= {"application/json"})
	public void addAuthor(@RequestBody aws author) 
	{
		repo.save(author);
		
	}
	
	@PutMapping(path="/author",consumes= {"application/json"})
	public void saveOrUpdateAuthor(@RequestBody aws author) 
	{
		repo.save(author);
		
	}
	
	@GetMapping(path="/author")
	public List<aws> getAuthors()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/author/{name}")
	public Optional<aws> getAuthor(@PathVariable("name") String name)
	{
		return repo.findById(name);

	}
	
	@DeleteMapping("/author/{name}")
	public void deleteAuthor(@PathVariable("name") String name)
	{
		aws a=repo.getById(name);
		repo.delete(a);
		
	}
}




