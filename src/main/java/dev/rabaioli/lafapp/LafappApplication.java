package dev.rabaioli.lafapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.rabaioli.lafapp.domain.Category;
import dev.rabaioli.lafapp.repositories.CategoryRepository;

@SpringBootApplication
public class LafappApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository cateRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(LafappApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "WithValue");
		Category cat2 = new Category(null, "OutValue");
		
		cateRepo.saveAll(Arrays.asList(cat1,cat2));
		
	}

}
