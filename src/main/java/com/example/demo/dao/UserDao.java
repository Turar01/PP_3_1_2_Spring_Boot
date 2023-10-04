package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserDao {
    List<User> getAllUsers();
    User getUser(long id);

    void save(User user);

    public void delete(long id);

    public void update(long id, User updatedUser);
}