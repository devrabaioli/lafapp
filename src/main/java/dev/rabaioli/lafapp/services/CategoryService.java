package dev.rabaioli.lafapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import dev.rabaioli.lafapp.domain.Category;
import dev.rabaioli.lafapp.dto.CategoryDTO;
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
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
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
	
	public Category fromDTO(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName());
	}


}
