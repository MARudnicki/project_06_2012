package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.ProductDao;
import com.kodilla.ecommercee.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    private final UserDao userDao;
    private final ProductDao productDao;

    @Autowired
    public OrderMapper(UserDao userDao, ProductDao productDao) {
        this.userDao = userDao;
        this.productDao = productDao;
    }

    public Order mapToOrder(final OrderDto orderDto) throws UserNotFoundException, ProductNotFoundException {
        return new Order(
                orderDto.getId(),
                userDao.findById(orderDto.getUserId()).orElseThrow(UserNotFoundException::new),
                orderDto.isRealised(),
                orderDto.getProducts().stream()
                .map(p -> {
                    try {
                        return productDao.findByName(p).orElseThrow(ProductNotFoundException::new);
                    } catch (ProductNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList())
        );
    }

     public OrderDto mapToOrderDto(final Order order){
        return new OrderDto(
                order.getId(),
                order.getUser().getId(),
                order.isRealised(),
                order.getProductList().stream()
                .map(Product::getName)
                .collect(Collectors.toList())
        );
     }

     public List<OrderDto> mapToOrderDtoList(final List<Order> orderList){
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
     }

}
