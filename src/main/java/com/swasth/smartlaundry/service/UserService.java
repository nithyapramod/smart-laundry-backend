package com.swasth.smartlaundry.service;

import com.swasth.smartlaundry.entity.User;
import com.swasth.smartlaundry.model.Login;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Response login(Login login) {
        Optional<User> userDetail = userRepository.findByPhoneNumberAndPasswordAndIsActiveTrue(login.getPhoneNumber(), login.getPassword());
        return userDetail.map(user -> new Response(true, HttpStatus.OK.value(), "Logged in successfully", user))
                .orElseGet(() -> new Response(false, HttpStatus.NOT_FOUND.value(), "User credential not matching or inactive", null));

    }

    public Response signup(Login login) {
        Optional<User> userDetail = userRepository.findByPhoneNumberAndIsActiveTrue(login.getPhoneNumber());
        Response response;
        if (!userDetail.isPresent()) {
            User signUp = new User();
            signUp.setName(login.getName());
            signUp.setPhoneNumber(login.getPhoneNumber());
            signUp.setPassword(login.getPassword());
            signUp.setIsOwner(false);
            signUp.setIsActive(true);
            signUp = userRepository.save(signUp);
            System.out.println(signUp.getUserId());
            response = new Response(true, HttpStatus.CREATED.value(), "Signed up successfully", null);
        } else {
            if (!userDetail.get().getIsActive()) {
                response = new Response(true, HttpStatus.OK.value(), "Account activated", null);
            } else {
                response = new Response(false, HttpStatus.OK.value(), "Mobile number already registered", null);
            }
        }
        return response;
    }

}
