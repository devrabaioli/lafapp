package dev.rabaioli.lafapp.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rabaioli.lafapp.domain.Pedido;
import dev.rabaioli.lafapp.domain.enums.EstadoPagamento;
import dev.rabaioli.lafapp.repositories.PagamentoRepository;
import dev.rabaioli.lafapp.repositories.PedidoRepository;
import dev.rabaioli.lafapp.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	public Pedido findbyId(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, invalid id: " + id + " Class: " + Pedido.class.getName()));
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstant(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
//		if (obj.getPagamento() instanceof PagamentoComBoleto) {
//			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
//			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
//		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
//		for (ItemPedido ip : obj.getItens()) {
//			ip.setDesconto(0.0);
//			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
//			ip.setPedido(obj);
//		}
		
		return obj;
	}

}
