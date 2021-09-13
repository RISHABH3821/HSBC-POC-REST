package com.albertsonspoc.UserShop.controllers;

import com.albertsonspoc.UserShop.dto.LoginDto;
import com.albertsonspoc.UserShop.dto.NewUserDto;
import com.albertsonspoc.UserShop.dto.UserProfileDto;
import com.albertsonspoc.UserShop.exception.ActionFailureException;
import com.albertsonspoc.UserShop.services.UserService;
import domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Response<String>> authenticate(@RequestBody LoginDto loginDto) {
        if (userService.isCredentialValid(loginDto.getUserName(), loginDto.getPassword())) {
            Response<String> response = new Response<>();
            response.setSuccessMessage("Success");
            response.setStatusCode("Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response<String> response = new Response<>();
            response.setError(new Response.Error().setMessage("Username or Password is not valid"));
            response.setStatusCode("Error");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/register")
    public void register(@RequestBody NewUserDto newUserDto) throws ActionFailureException {
        userService.createNewUser(newUserDto);
    }

    @GetMapping("/address")
    public ResponseEntity<Response<String>> authenticate(@RequestParam("userName") String userName) throws ActionFailureException {
        Response<String> response = new Response<>();
        response.setData(Collections.singletonList(userService.findAddress(userName)));
        response.setSuccessMessage("Success");
        response.setStatusCode("Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<Response<UserProfileDto>> getProfile(@RequestParam("userName") String userName) throws ActionFailureException {
        Response<UserProfileDto> response = new Response<>();
        response.setData(Collections.singletonList(userService.getUserProfile(userName)));
        response.setSuccessMessage("Success");
        response.setStatusCode("Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/profile")
    public void updateProfile(@RequestParam("userName") String userName, @RequestBody UserProfileDto userProfileDto) throws ActionFailureException {
        userService.updateUserProfile(userName, userProfileDto);
    }

}
