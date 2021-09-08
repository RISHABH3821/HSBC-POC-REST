package com.albertsonspoc.UserShop.services;

import com.albertsonspoc.UserShop.models.User;
import com.albertsonspoc.UserShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
