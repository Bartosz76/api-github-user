package bm.app.apigithubuser.controller;

import bm.app.apigithubuser.model.User;
import bm.app.apigithubuser.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ThymeleafController {

    private UserService userService;

    public ThymeleafController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/landingpage")
    public String getLandingPage() {
        return "landingpage";
    }

    @PostMapping("/ascending")
    public String getTheResultWithAscendingOrder(@RequestParam String user,
                                                 Model model) throws IOException {
        User[] arrayAscending = userService.fetchUserByStarsDescendingOrder(user);
        model.addAttribute("array", arrayAscending);
        return "result";
    }

    @PostMapping("/descending")
    public String getTheResultWithDescendingOrder(@RequestParam String user,
                                                  Model model) throws IOException {
        User[] arrayDescending = userService.fetchUserByStarsAscendingOrder(user);
        model.addAttribute("array", arrayDescending);
        return "result";
    }
}
