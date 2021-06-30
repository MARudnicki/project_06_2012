package com.kodilla.ecommercee;

import com.kodilla.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {

    @GetMapping("/getOrders")
    public List<OrderDto> getOrders() { return new ArrayList<>(); }

    @GetMapping("/getOrder/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return new OrderDto(
                1L,
                true,
                new ArrayList<>()
        );
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {
    }

    @PutMapping(value = "updateOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(
                orderDto.getUserId(),
                orderDto.isRealized(),
                orderDto.getProducts()
        );
    }

    @DeleteMapping(value = "deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {}
}