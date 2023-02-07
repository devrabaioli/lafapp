package dev.rabaioli.lafapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rabaioli.lafapp.domain.Category;
import dev.rabaioli.lafapp.repositories.CategoryRepository;
import dev.rabaioli.lafapp.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category findbyId(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, invalid id: " + id + " Class: " + Category.class.getName()));
	}

}
