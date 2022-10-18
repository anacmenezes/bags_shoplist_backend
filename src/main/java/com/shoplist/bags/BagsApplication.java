package com.shoplist.bags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shoplist.bags.repositories.CategoryRepository;

@SpringBootApplication
public class BagsApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(BagsApplication.class, args);
	}
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... enderecoeRepository) throws Exception {
		
		categoryRepository.deleteAll();
		
//		Category cat1 = new Category(null, "Congelados");
//		Category cat2 = new Category(null, "Laticínios");
//		
//		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}
}
