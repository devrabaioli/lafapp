package dev.rabaioli.lafapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import dev.rabaioli.lafapp.domain.Category;
import dev.rabaioli.lafapp.repositories.CategoryRepository;
import dev.rabaioli.lafapp.services.exceptions.DataIntegrityException;
import dev.rabaioli.lafapp.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category findbyId(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, invalid id: " + id + " Class: " + Category.class.getName()));
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		 return repo.save(obj);
	}
	
	public Category update(Category obj) {
		findbyId(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findbyId(id);
		
		try {
			repo.deleteById(id);
			
		}catch (DataIntegrityViolationException e) {
		   throw new DataIntegrityException("Impossible to delete. Other referenced objects ");
		}
		
	}
	
	public List<Category> findAll(){
		return repo.findAll();
	}

}
