package com.surveycenter.service;

import com.surveycenter.pojo.User;

import java.util.List;

public interface UserService {

    List<User> selectAllUsers();

    User findUser(String username, String password);

    User findUserByName(String username);

    int addUser(User registerUser);

    User findUserById(int id);

    int setUsername(int id, String username);

    User getUserByPhone(String phone);

    int setPhone(int id, String phone);

    String getBeforePhone(int id);

    int getBeforeSex(int id);

    int setSex(int id, int sex);

    String getBeforeDate(int id);

    int setDate(int id, String date);

    String getNameById(int id);

    int resetPass(int id, String password);
}
