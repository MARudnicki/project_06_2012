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
                new UserDto(10L,"user","o",31251L),
                new ProductDto(20L,"kurtka zimowa", "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus lorem non auctor. Vivamus erat turpis, molestie a nisl non, scelerisque luctus enim. Nunc mi mi, laoreet ac mollis nec, pharetra sit amet tortor. Vivamus a bibendum purus.", new BigDecimal(100)),
                true
        );
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {
        boolean orderDtos = orderDto.getOrder().add(orderDto);
    }

    @PutMapping("updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(
                1L,
                new UserDto(10L,"user","o",31251L),
                new ProductDto(20L,"kurtka zimowa", "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus lorem non auctor. Vivamus erat turpis, molestie a nisl non, scelerisque luctus enim. Nunc mi mi, laoreet ac mollis nec, pharetra sit amet tortor. Vivamus a bibendum purus.", new BigDecimal(100)),
                true
        );
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(Long OrderId) {}
}
