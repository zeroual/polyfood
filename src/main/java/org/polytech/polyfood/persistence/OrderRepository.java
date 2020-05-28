package org.polytech.polyfood.persistence;

import org.polytech.polyfood.buisness.Order;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findByConsumerId(Long consumerId);

    Order findById(Long id);
}
