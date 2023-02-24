package dev.rabaioli.lafapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rabaioli.lafapp.domain.Category;
import dev.rabaioli.lafapp.domain.Client;
import dev.rabaioli.lafapp.domain.Lost;
import dev.rabaioli.lafapp.domain.Pagamento;
import dev.rabaioli.lafapp.domain.PagamentoAUTORIDADE;
import dev.rabaioli.lafapp.domain.PagamentoCliente;
import dev.rabaioli.lafapp.domain.Pedido;
import dev.rabaioli.lafapp.domain.UserAPP;
import dev.rabaioli.lafapp.domain.enums.EstadoPagamento;
import dev.rabaioli.lafapp.repositories.CategoryRepository;
import dev.rabaioli.lafapp.repositories.ClientRepository;
import dev.rabaioli.lafapp.repositories.LostRepository;
import dev.rabaioli.lafapp.repositories.PagamentoRepository;
import dev.rabaioli.lafapp.repositories.PedidoRepository;
import dev.rabaioli.lafapp.repositories.UserAPPRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoryRepository cateRepo;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private LostRepository lostRepo;
	
	@Autowired
	private PagamentoRepository pagamentoRepo;
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private UserAPPRepository userAPPRepo;
	
	public void instantiateTestDatabase() throws ParseException {
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

         UserAPP user1 = new UserAPP(null, "Helio Silva", "helio@auchan.pt");
         UserAPP user2 = new UserAPP(null, "Joao Domingues", "joaodomingues@auchan.pt");
         
         userAPPRepo.saveAll(Arrays.asList(user1,user2));
         
		
		Category cat1 = new Category(null, "WithValue");
		Category cat2 = new Category(null, "OutValue");
		
		Lost lost1 = new Lost(null, "Carteira com documentos", "Operadora caixas", "caixa 15", "Helio Silva", sdf.parse("10/01/2023 10:11"));
		cat1.getLosts().addAll(Arrays.asList(lost1));
		
		Lost lost2 = new Lost(null, "Meia de criança cor de rosa", "Cliente", "Quiq 1", "Joao Domingues", sdf.parse("11/01/2023 11:13"));
		cat2.getLosts().addAll(Arrays.asList(lost2));
		
		lost1.getCategories().addAll(Arrays.asList(cat1));
		lost2.getCategories().addAll(Arrays.asList(cat2));
		

		cateRepo.saveAll(Arrays.asList(cat1,cat2));
		lostRepo.saveAll(Arrays.asList(lost1,lost2));
		
		Client cli1 = new Client(null, "Esquadra PSP", "Amadora");
		cli1.getTelefones().addAll(Arrays.asList("93455454545"));

		Client cli2 = new Client(null, "Fernanda Alves", "Odivelas");
		cli2.getTelefones().addAll(Arrays.asList("93433232312"));
		
		clientRepo.saveAll(Arrays.asList(cli1,cli2));
		
		Pedido pede1 = new Pedido(null, sdf.parse("11/01/2023 10:32"), cli1,lost1); //Entregua PSP dia seguinte
		Pedido pede2 = new Pedido(null, sdf.parse("11/01/2013 11:56"), cli2,lost2);
		
		Pagamento pagto1 = new PagamentoAUTORIDADE(null, EstadoPagamento.ENTREGUEAUTORIDADE, pede1, sdf.parse("11/01/2023 10:32"));
		pede1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoCliente(null, EstadoPagamento.ENTREGUECLIENTE, pede2, sdf.parse("11/01/2013 11:56"));
		pede2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(pede1));
		
		cli2.getPedidos().addAll(Arrays.asList(pede2));
		
		
		pedidoRepo.saveAll(Arrays.asList(pede1,pede2));
		pagamentoRepo.saveAll(Arrays.asList(pagto1,pagto2));
		
		
		
		
	}

}
