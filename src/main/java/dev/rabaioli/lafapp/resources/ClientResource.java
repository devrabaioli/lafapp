package dev.rabaioli.lafapp.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.rabaioli.lafapp.domain.Client;
import dev.rabaioli.lafapp.dto.ClientDTO;
import dev.rabaioli.lafapp.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> findById(@PathVariable Integer id){
		Client obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
		
		
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClientDTO objDto, @PathVariable Integer id){
		Client obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientDTO>> findAll(){
	    List<Client> list =  service.findAll();
	    List<ClientDTO> listDto = list.stream().map(obj -> new ClientDTO(obj)).collect(Collectors.toList());
	   return ResponseEntity.ok().body(listDto);
	}


}
