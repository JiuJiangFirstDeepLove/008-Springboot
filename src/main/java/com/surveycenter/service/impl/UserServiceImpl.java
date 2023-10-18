package com.surveycenter.service.impl;

import com.surveycenter.mapper.UserMapper;
import com.surveycenter.pojo.User;
import com.surveycenter.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public User findUser(String username, String password) {
        return userMapper.findUser(username,password);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public int addUser(User registerUser) {
        return userMapper.addUser(registerUser);
    }

    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public int setUsername(int id, String username) {
        return userMapper.setUsername(id,username);
    }

    @Override
    public User getUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    @Override
    public int setPhone(int id, String phone) {
        return userMapper.setPhone(id,phone);
    }

    @Override
    public String getBeforePhone(int id) {
        return userMapper.getBeforePhone(id);
    }

    @Override
    public int getBeforeSex(int id) {
        return userMapper.getBeforeSex(id);
    }

    @Override
    public int setSex(int id, int sex) {
        return userMapper.setSex(id,sex);
    }

    @Override
    public String getBeforeDate(int id) {
        return userMapper.getBeforeDate(id);
    }

    @Override
    public int setDate(int id, String date) {
        return userMapper.setDate(id,date);
    }

    @Override
    public String getNameById(int id) {
        return userMapper.getNameById(id);
    }

    @Override
    public int resetPass(int id, String password) {
        return userMapper.resetPass(id,password);
    }
}
