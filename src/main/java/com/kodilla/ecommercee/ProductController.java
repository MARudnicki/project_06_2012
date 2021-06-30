package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping(value = "getProducts")
    public List<ProductDto_> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping("/getProduct/{productId}")
    public ProductDto_ getProduct(@PathVariable Long productId){
        return new ProductDto_(1L, "Test product", "Test description", new BigDecimal("99.99"), 2L);
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto_ productDto) {
    }

    @PutMapping("updateProduct")
    public ProductDto_ updateProduct(@RequestBody ProductDto_ productDto) {
        return new ProductDto_(1L, "Edited test product", "Edited test description", new BigDecimal("99.99"), 2L);
    }

    @DeleteMapping(value = "/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
    }

}
