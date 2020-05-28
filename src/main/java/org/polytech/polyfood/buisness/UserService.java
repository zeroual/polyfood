package org.polytech.polyfood.buisness;

import org.polytech.polyfood.persistence.UserRepository;

public class UserService {

    UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) {
        User byUsername = this.userRepository.findByUsername(user.getUsername());
        if (byUsername != null) {
            throw new RuntimeException("USER ALREADY EXISTS");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}
