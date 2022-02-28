package com.example.demo1.Model.dao;

import com.example.demo1.Model.bo.User;

import java.util.Collection;

public interface IDAOUser {
    void Create(User user);
    Collection<User> Retrieve();
    void update(User user);
    boolean delete(User user);
}
