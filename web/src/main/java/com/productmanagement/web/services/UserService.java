package com.productmanagement.web.services;

import com.productmanagement.web.models.User;

public interface UserService {

    void saveUser(User user);
    User findByEmail(String email);
    User findByUsername(String username);
}
