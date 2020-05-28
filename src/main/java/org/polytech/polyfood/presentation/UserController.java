package org.polytech.polyfood.presentation;


import org.polytech.polyfood.buisness.User;
import org.polytech.polyfood.buisness.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/users")
    public void register(@RequestBody User user) {
        userService.register(user);
    }
}
