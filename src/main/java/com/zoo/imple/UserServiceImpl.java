package com.zoo.imple;

import com.zoo.entities.User;
import com.zoo.exptions.ResourseNotFoundException;
import com.zoo.repository.userRepository;
import com.zoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    private userRepository userRepository;

    @Override
    public User saveUser(User user) {
      String radomUserID = UUID.randomUUID().toString();
      user.setUserID(radomUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getALlUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userID) {
        return userRepository.findById(userID).orElseThrow(()->new ResourseNotFoundException("Resource Not found on server with : "+ userID ));


    }
}

