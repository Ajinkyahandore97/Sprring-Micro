package com.zoo.service;

import com.zoo.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getALlUser();

    User getUser(String userID);

}
