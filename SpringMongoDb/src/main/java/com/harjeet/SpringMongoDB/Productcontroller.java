package com.harjeet.SpringMongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
public class Productcontroller {
	@Autowired
	private ProductResp rep;
	
	@PostMapping
	public Mono<Product> addProduct(@RequestBody Product product){
		return rep.save(product);
		
	}
	
	@GetMapping("/{id}")
	public Flux<Product> getProducts(){
		return rep.findAll();
	}
	
}

