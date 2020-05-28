package org.polytech.polyfood.persistence;

import org.polytech.polyfood.buisness.User;

public interface UserRepository {
    User findByUsername(String username);

    void save(User user);
}
