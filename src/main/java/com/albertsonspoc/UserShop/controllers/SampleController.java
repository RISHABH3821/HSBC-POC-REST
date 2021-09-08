package com.albertsonspoc.UserShop.controllers;

import com.albertsonspoc.UserShop.models.User;
import com.albertsonspoc.UserShop.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/users")
    public List<User> getAll(){
        return sampleService.getAllUsers();
    }
}
