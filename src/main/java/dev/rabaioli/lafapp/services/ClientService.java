package dev.rabaioli.lafapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import dev.rabaioli.lafapp.domain.Client;
import dev.rabaioli.lafapp.dto.ClientDTO;
import dev.rabaioli.lafapp.repositories.ClientRepository;
import dev.rabaioli.lafapp.services.exceptions.DataIntegrityException;
import dev.rabaioli.lafapp.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public Client findbyId(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, invalid id: " + id + " Class: " + Client.class.getName()));
	}
	
	public Client update(Client obj) {
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
	
	public List<Client> findAll(){
		return repo.findAll();
	}
	
	public Client fromDTO(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getLocalidade());
	}

	

}
