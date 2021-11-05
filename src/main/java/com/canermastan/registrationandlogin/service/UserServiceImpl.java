package com.canermastan.registrationandlogin.service;

import com.canermastan.registrationandlogin.dao.UserRepository;
import com.canermastan.registrationandlogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }


}
