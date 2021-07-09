package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public Order getOrder(Long id) throws OrderNotFoundException {
        return orderDao.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public Order saveOrder(final Order order) {
        return orderDao.save(order);
    }

    public void deleteOrder(Long id){
        orderDao.deleteById(id);
    }

}
