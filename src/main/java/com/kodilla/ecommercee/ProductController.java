package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping("/getProduct/{productId}")
    public ProductDto getProduct(@PathVariable Long productId){
        return new ProductDto(1L, "Test product", "Test description", new BigDecimal("99.99"), 2L);
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
    }

    @PutMapping("updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return new ProductDto(1L, "Edited test product", "Edited test description", new BigDecimal("99.99"), 2L);
    }

    @DeleteMapping(value = "/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
    }

}
