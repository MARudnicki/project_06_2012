package com.kodilla.ecommercee;

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

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(Long productId) {

    }

}
