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
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LostService lostService;
	
	@Autowired
	private EmailService emailService;
	
	
	public Pedido findbyId(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, invalid id: " + id + " Class: " + Pedido.class.getName()));
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstant(new Date());
		obj.setClient(clientService.findbyId(obj.getClient().getId()));
		obj.setLost(lostService.findbyId(obj.getLost().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
//		if (obj.getPagamento() instanceof PagamentoComBoleto) {
//			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
//			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
//		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());

		System.out.println(obj.toString());
		emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}

}
