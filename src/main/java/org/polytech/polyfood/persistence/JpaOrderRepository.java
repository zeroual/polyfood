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
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
    }

    public List<Order> findByConsumerId(Long consumerId) {

        String query = "SELECT o FROM Order o WHERE o.consumerId=:consumerId";

        return entityManager.createQuery(query, Order.class)
                .setParameter("consumerId", consumerId)
                .getResultList();
    }

    @Override
    public Order findById(Long id) {
        return entityManager.find(Order.class, id);
    }
}
