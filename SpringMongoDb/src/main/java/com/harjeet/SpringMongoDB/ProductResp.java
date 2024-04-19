package com.harjeet.SpringMongoDB;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductResp extends ReactiveMongoRepository<Product, String>{

}
