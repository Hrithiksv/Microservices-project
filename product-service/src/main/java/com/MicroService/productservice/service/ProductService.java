package com.MicroService.productservice.service;

import com.MicroService.productservice.dto.ProductRequest;
import com.MicroService.productservice.dto.ProductResponse;
import com.MicroService.productservice.model.Products;
import com.MicroService.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

//**  @RequiredArgsConstructor -- this will create a constructor for us in compile time
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public void createProduct(ProductRequest productRequest){
        //**map product request to product model
        Products products = Products.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(products);
        //** {} is a placeholder which will replace by productID in compile time
        log.info("Product {} is saved", products.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Products> products= productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Products product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }
}
