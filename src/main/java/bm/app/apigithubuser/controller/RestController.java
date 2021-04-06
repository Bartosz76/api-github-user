package bm.app.apigithubuser.controller;

import bm.app.apigithubuser.model.User;
import bm.app.apigithubuser.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    private UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{user}/repos/asc")
    public User[] getUserDataStarsDescending(@PathVariable String user) throws IOException {
        return userService.fetchUserByStarsDescendingOrder(user);
    }

    @GetMapping("/users/{user}/repos/desc")
    public User[] getUserDataStarsAscending(@PathVariable String user) throws IOException {
        return userService.fetchUserByStarsAscendingOrder(user);
    }
}
