package dev.rabaioli.lafapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rabaioli.lafapp.domain.Client;
import dev.rabaioli.lafapp.repositories.ClientRepository;
import dev.rabaioli.lafapp.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public Client findbyId(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, invalid id: " + id + " Class: " + Client.class.getName()));
	}
	

}
