package com.qa.application.mapper;

import com.qa.application.entity.Product;
import com.qa.application.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    Product mapToProduct(ProductDto productDto);
    ProductDto mapToProductDto(Product product);

}
