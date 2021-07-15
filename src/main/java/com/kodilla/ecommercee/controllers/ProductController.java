package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductDao;
import com.kodilla.ecommercee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    @GetMapping(value = "/getProducts")
    public List<ProductDto> getProducts() {
        List<Product> productList = productService.getAllProducts();
        return productMapper.mapToProductDtoList(productList);
    }

    @GetMapping(value = "/getProduct/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(
                productService.getProduct(productId)
        );
    }

    @PostMapping(value = "/createProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) throws OrderNotFoundException {
        Product product = productMapper.mapToProduct(productDto);
        productService.saveProduct(product);
    }

    @PutMapping(value = "/updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws OrderNotFoundException {
        Product product = productMapper.mapToProduct(productDto);
        Product saveProduct = productService.saveProduct(product);
        return productMapper.mapToProductDto(saveProduct);
    }

    @DeleteMapping(value = "/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

}
