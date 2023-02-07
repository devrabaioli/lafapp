package dev.rabaioli.lafapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.rabaioli.lafapp.domain.Pedido;
import dev.rabaioli.lafapp.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> findById(@PathVariable Integer id){
		Pedido obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
		
		
	}

}
