package com.MicroService.productservice.repository;

import com.MicroService.productservice.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products, String > {
}
