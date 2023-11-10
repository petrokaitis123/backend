package com.qa.application.service.impl;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.exception.product.ProductNotFoundException;
import com.qa.application.entity.Product;
import com.qa.application.mapper.ProductMapper;
import com.qa.application.model.ProductDto;
import com.qa.application.repository.ProductRepository;
import com.qa.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(p ->
                products.add(p));
        return products.stream().map((p) -> productMapper.MAPPER.mapToProductDto(p))
                .collect(Collectors.toList());
    }
    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.MAPPER.mapToProductDto(product);
    }
    @Override
    public ResponseEntity<MessageResponse> addProduct(ProductDto productDto) {
        Product product = productMapper.MAPPER.mapToProduct(productDto);
        productRepository.save(product);
        return ResponseEntity.ok(new MessageResponse("Product added successfully"));
    }
    @Override
    public ProductDto updateProduct(Integer id, ProductDto newProductDto) {
        Product existingProduct = productRepository.findProductById(id)
                        .orElseThrow(() -> new ProductNotFoundException(id));
        existingProduct.setProductNumber(newProductDto.getProductNumber());
        existingProduct.setName(newProductDto.getName());
        existingProduct.setDescription(newProductDto.getDescription());
        return productMapper.MAPPER.mapToProductDto(productRepository.save(existingProduct));
    }

    @Override
    public void deleteProduct(Integer id) {
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
