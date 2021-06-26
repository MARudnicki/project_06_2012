package com.kodilla.ecommercee;

import com.kodilla.dto.OrderDto;
import com.kodilla.dto.ProductDto;
import com.kodilla.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @PutMapping("updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(
                orderDto.getIdUser(),
                orderDto.isRealized(),
                orderDto.getOrderProducts()
        );
    }

    @DeleteMapping(value = "deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {}
}
