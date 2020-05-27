package org.polytech.polyfood.persistence;

import org.polytech.polyfood.buisness.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaOrderRepository implements OrderRepository {


    private EntityManager entityManager;

    public JpaOrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Order order) {
        entityManager.persist(order);
    }

    public List<Order> findByConsumerId(Long consumerId) {
        return null;
    }
}
