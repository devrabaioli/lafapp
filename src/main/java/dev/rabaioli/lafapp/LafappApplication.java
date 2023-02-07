package dev.rabaioli.lafapp;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.rabaioli.lafapp.domain.Category;
import dev.rabaioli.lafapp.domain.Lost;
import dev.rabaioli.lafapp.repositories.CategoryRepository;
import dev.rabaioli.lafapp.repositories.LostRepository;

@SpringBootApplication
public class LafappApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository cateRepo;
	
	@Autowired
	private LostRepository lostRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(LafappApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
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
		
	}

}
