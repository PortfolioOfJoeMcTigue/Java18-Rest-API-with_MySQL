package com.mctigue.ready_set_cert_api.service;

import com.mctigue.ready_set_cert_api.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getUsers();
    public List<User> getUserName(Integer userId);
    public void addUser(User user);
    public void deleteUser(int id);
}
