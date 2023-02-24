package dev.rabaioli.lafapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import dev.rabaioli.lafapp.domain.UserAPP;
import dev.rabaioli.lafapp.repositories.UserAPPRepository;
import dev.rabaioli.lafapp.services.exceptions.DataIntegrityException;
import dev.rabaioli.lafapp.services.exceptions.ObjectNotFoundException;

@Service
public class UserAPPService {
	
	@Autowired
	private UserAPPRepository repo;
	
	public UserAPP findbyId(Integer id) {
		Optional<UserAPP> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, invalid id: " + id + " Class: " + UserAPP.class.getName()));
	}
	
	public Page<UserAPP> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public UserAPP insert(UserAPP obj) {
		obj.setId(null);
		 return repo.save(obj);
	}
	
	public UserAPP update(UserAPP obj) {
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
	
	public List<UserAPP> findAll(){
		return repo.findAll();
	}
	
	


}
