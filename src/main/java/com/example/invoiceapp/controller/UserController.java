package com.example.invoiceapp.controller;

import com.example.invoiceapp.model.User;
import com.example.invoiceapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    // Register a new user
    @CrossOrigin(origins = {"http://localhost:4200", "https://invoice-app-springboot.herokuapp.com"})
    @PostMapping("/register")
    public ResponseEntity<User> saveInvoice(@RequestBody User user) {
        System.out.println(user);

        return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);
    }
}
