package com.albertsonspoc.UserShop.services;

import com.albertsonspoc.UserShop.dto.NewUserDto;
import com.albertsonspoc.UserShop.dto.UserProfileDto;
import com.albertsonspoc.UserShop.exception.ActionFailureException;
import com.albertsonspoc.UserShop.models.User;
import com.albertsonspoc.UserShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isCredentialValid(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    public void createNewUser(NewUserDto newUserDto) throws ActionFailureException {
        if (userRepository.findByUserName(newUserDto.getUserName()).isPresent()) {
            throw new ActionFailureException("Username already in use");
        }

        User user = new User();
        user.setFullName(newUserDto.getFullName());
        user.setUserName(newUserDto.getUserName());
        user.setAddress(newUserDto.getAddress());
        user.setEmail(newUserDto.getEmail());
        user.setPhone(newUserDto.getPhone());
        user.setPassword(newUserDto.getPassword());

        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new ActionFailureException(e.getMessage());
        }
    }

    public String findAddress(String userName) throws ActionFailureException {
        return userRepository.findByUserName(userName).orElseThrow(() -> new ActionFailureException("User not found")).getAddress();
    }

    public UserProfileDto getUserProfile(String userName) throws ActionFailureException {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new ActionFailureException("User Not Found"));
        return new UserProfileDto(user.getFullName(), user.getEmail(), user.getPhone(), user.getAddress());
    }

    public void updateUserProfile(String userName, UserProfileDto userProfileDto) throws ActionFailureException {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new ActionFailureException("User Not Found"));
        user.setFullName(userProfileDto.getFullName());
        user.setAddress(userProfileDto.getAddress());
        user.setEmail(userProfileDto.getEmail());
        user.setPhone(userProfileDto.getPhone());
        userRepository.save(user);
    }

}
