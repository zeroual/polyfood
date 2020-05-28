package org.polytech.polyfood.persistence;

import org.polytech.polyfood.buisness.User;

import javax.persistence.EntityManager;

public class JpaUserRepository implements UserRepository {

    private EntityManager entityManager;

    public JpaUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    public void save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
