package com.mctigue.ready_set_cert_api.service.impl;

import com.mctigue.ready_set_cert_api.Repository.UserRepository;
import com.mctigue.ready_set_cert_api.model.User;
import com.mctigue.ready_set_cert_api.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUserName(Integer userId) {
        List<User> user = getUsers()
                .stream()
                .filter(users -> users.getId().equals(userId)).toList();
        return user;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        List<User> users = userRepository.findAll();
        for (int x = 0; x < users.size(); x++) {
            if (users.get(x).getId() == id) {
                users.remove(users.get(x));
            }
        }
    }
}
