package com.example.springdataelasticdemo.service.impl;

import com.example.springdataelasticdemo.model.User;
import com.example.springdataelasticdemo.repository.UsersRepository;
import com.example.springdataelasticdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UsersRepository usersRepository;
    @Override
    public User findUserByUserId(long id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public List<User> findUserByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public List<User> findUserBySalary(long salary) {
        return usersRepository.findBySalary(salary);
    }
}
