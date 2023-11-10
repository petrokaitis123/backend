package com.qa.application.service;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.model.ProductDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Integer id);

    ResponseEntity<MessageResponse> addProduct(@Valid ProductDto productDto);

    ProductDto updateProduct(Integer id, ProductDto newProductDto);

    void deleteProduct(Integer id);




}
