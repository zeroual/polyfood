package org.polytech.polyfood.buisness;

import org.polytech.polyfood.persistence.OrderRepository;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) {
        // verify consumer details
        // verify that restaurant is opened
        // ask restaurant to prepare this ticket
        // verify user paymentInformation
        // if all ok then save order in database
        this.orderRepository.save(order);
        // send notification to user
    }

    public List<Order> fetchConsumerOrders(Long consumerId) {
        return this.orderRepository.findByConsumerId(consumerId);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id);
    }
}
