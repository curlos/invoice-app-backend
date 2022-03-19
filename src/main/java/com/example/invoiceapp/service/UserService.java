package com.example.invoiceapp.service;

import com.example.invoiceapp.model.User;

public interface UserService {
    User registerUser(User user);
    User login(User user);
}
