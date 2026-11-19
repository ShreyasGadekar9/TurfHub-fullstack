package com.turfhub.turfhub_backend.service;

import com.turfhub.turfhub_backend.model.User;
import com.turfhub.turfhub_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Register a new user
    public User register(User user) {
        User existing = userRepository.findByEmail(user.getEmail());
        if (existing != null) {
            throw new RuntimeException("Email is already registered");
        }
        return userRepository.save(user);
    }

    //Login
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password");
        }
        return user;
    }
}

