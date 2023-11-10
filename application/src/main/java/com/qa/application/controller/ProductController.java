package com.qa.application.controller;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.model.ProductDto;
import com.qa.application.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/products")
public class ProductController {

    ProductService productService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ResponseBody
    public List<ProductDto> getAll() {
       return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ResponseBody
    public ProductDto getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }


    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @ResponseBody
    public ResponseEntity<MessageResponse> addProduct(@RequestBody @Valid ProductDto productDto) {
      return productService.addProduct(productDto);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @ResponseBody
    public ProductDto updateProduct(@RequestBody ProductDto newProductDto, @PathVariable Integer id) {
       return productService.updateProduct(id, newProductDto);
    }
    //delete product
    @DeleteMapping("/product/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteUser(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

}
