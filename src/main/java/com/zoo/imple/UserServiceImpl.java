package com.zoo.imple;

import com.zoo.entities.User;
import com.zoo.exptions.ResourseNotFoundException;
import com.zoo.repository.userRepository;
import com.zoo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private  Logger logger  = LoggerFactory.getLogger(UserServiceImpl.class);



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
        User user=  userRepository.findById(userID).orElseThrow(()->new ResourseNotFoundException("Resource Not found on server with : "+ userID ));
 // http://localhost:8091/ratings/userId/bb38a302-cb6a-4ed9-ab58-961289f59760

        ArrayList forObject = restTemplate.getForObject("http://localhost:8091/ratings/userId/"+ user.getUserID(), ArrayList.class);

        logger.info("{}",forObject);

        return  user;

    }
}

