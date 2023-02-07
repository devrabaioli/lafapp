package dev.rabaioli.lafapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.rabaioli.lafapp.domain.Category;
import dev.rabaioli.lafapp.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> findById(@PathVariable Integer id){
		Category obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
		
		
	}

}
