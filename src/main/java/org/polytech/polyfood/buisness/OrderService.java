package org.polytech.polyfood.buisness;

import org.polytech.polyfood.persistence.JdbcOrderRepository;

import java.util.List;

public class OrderService {
    private JdbcOrderRepository jdbcOrderRepository = new JdbcOrderRepository();

    public void createOrder(Order order) {
        // verify consumer details
        // verify that restaurant is opened
        // ask restaurant to prepare this ticket
        // verify user paymentInformation
        // if all ok then save order in database
        this.jdbcOrderRepository.save(order);
        // send notification to user
    }

    public List<Order> fetchConsumerOrders(Long consumerId){
        return this.jdbcOrderRepository.findByConsumerId(consumerId);
    }
}
