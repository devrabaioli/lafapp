package dev.rabaioli.lafapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rabaioli.lafapp.domain.Pedido;
import dev.rabaioli.lafapp.repositories.PedidoRepository;
import dev.rabaioli.lafapp.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido findbyId(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, invalid id: " + id + " Class: " + Pedido.class.getName()));
	}

}
