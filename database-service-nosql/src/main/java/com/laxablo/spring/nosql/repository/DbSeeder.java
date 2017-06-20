//package com.laxablo.spring.nosql.repository;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.laxablo.spring.nosql.entity.TroubleEntity;
//
//@Component
//public class DbSeeder implements CommandLineRunner {
//
//	@Autowired
//	private TroubleRepository troubleRepository;
//	
////	public DbSeeder(TroubleRepository troubleRepository) {
////		this.troubleRepository = troubleRepository;
////	}
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		TroubleEntity trouble1 = new TroubleEntity("Product 1", "Trouble with package", 
//				Arrays.asList("picture1", "picture2"));
//		TroubleEntity trouble2 = new TroubleEntity("Product 5", "Trouble with materials", 
//				Arrays.asList("picture1"));
//		TroubleEntity trouble3 = new TroubleEntity("Product 23", "Trouble with quantity", 
//				new ArrayList<>());
//	
//		List<TroubleEntity> troubles = Arrays.asList(trouble1, trouble2, trouble3);
//		
//		this.troubleRepository.deleteAll();
//		this.troubleRepository.save(troubles);
//		
//	}
//
//	
//}
