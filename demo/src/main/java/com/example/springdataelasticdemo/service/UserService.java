package com.example.springdataelasticdemo.service;

import com.example.springdataelasticdemo.model.User;

import java.util.List;

public interface UserService {
    public User findUserByUserId(long id);
    public List<User> findUserByName(String id);
    public List<User> findUserBySalary(long salary);

}
