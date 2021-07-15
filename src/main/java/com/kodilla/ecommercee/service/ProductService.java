package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.repository.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product getProduct(Long id) throws ProductNotFoundException {
        return productDao.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public Product saveProduct(final Product order) {
        return productDao.save(order);
    }

    public void deleteProduct(Long id){
        productDao.deleteById(id);
    }

}
