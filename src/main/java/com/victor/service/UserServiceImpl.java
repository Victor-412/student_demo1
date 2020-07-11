package com.victor.service;

import com.victor.mapper.UserMapper;
import com.victor.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName, password);
    }
}
