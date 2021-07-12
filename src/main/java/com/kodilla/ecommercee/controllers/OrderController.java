package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;
    private final OrderService orderService;

    @GetMapping("/getOrders")
    public List<OrderDto> getOrders() {
        List<Order> orders = orderService.getAllOrders();
        return orderMapper.mapToOrderDtoList(orders); }

    @GetMapping("/getOrder/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(
                orderService.getOrder(orderId)
        );
    }

    @PostMapping(value = "/createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) throws UserNotFoundException, ProductNotFoundException {
        Order order = orderMapper.mapToOrder(orderDto);
        orderService.saveOrder(order);
    }

    @PutMapping(value = "/updateOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) throws UserNotFoundException, ProductNotFoundException {
        Order order = orderMapper.mapToOrder(orderDto);
        Order saveOrder = orderService.saveOrder(order);
        return orderMapper.mapToOrderDto(saveOrder);
    }

    @DeleteMapping(value = "/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
