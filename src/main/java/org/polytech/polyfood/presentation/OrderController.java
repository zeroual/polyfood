package org.polytech.polyfood.presentation;

import org.polytech.polyfood.buisness.Order;
import org.polytech.polyfood.buisness.OrderService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class OrderController {


    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // curl http://localhost:8080/hello?name=toto > request param
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "Hello " + name;
    }


    // curl -X POST --data="{}" http://localhost:8080/orders -> request body
    @PostMapping("/orders")
    public Order placeOrder(@RequestBody Order order, Principal principal) {

        // GET CONNECTED USER
        String username = principal.getName();
        orderService.createOrder(order);
        return order;
    }


    // GET http://localhost:8080/orders?consumerId=982738
    @GetMapping("/orders")
    List<Order> ordersByConsumer(@RequestParam("consumerId") Long consumerId) {
        return orderService.fetchConsumerOrders(consumerId);
    }

    // curl http://localhost:8080/orders/54242 > pathVariable
    @GetMapping("/orders/{id}")
    public Order fetchOrderById(@PathVariable("id") Long id) {
        return orderService.getOrder(id);
    }

}
