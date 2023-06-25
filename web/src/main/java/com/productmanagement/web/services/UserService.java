package com.productmanagement.web.services;

import com.productmanagement.web.models.UserEntity;

public interface UserService {

    void saveUser(UserEntity user);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
