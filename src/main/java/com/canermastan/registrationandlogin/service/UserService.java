package com.canermastan.registrationandlogin.service;

import com.canermastan.registrationandlogin.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findByEmail(String email);
    List<User> findAll();
}
