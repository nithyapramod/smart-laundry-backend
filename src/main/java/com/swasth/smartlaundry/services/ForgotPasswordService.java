package com.swasth.smartlaundry.services;

import javax.transaction.Transactional;

import com.swasth.smartlaundry.model.ForgotPassword;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ForgotPasswordService {

    @Autowired
    private UserRepository userRepository;

    public Response updatePassword(ForgotPassword forgotPassword) {

        String regex = "(0/91)?[6-9][0-9]{9}";

        if (!forgotPassword.getPhoneNumber().matches(regex)) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "please satisfy mobile number conditions",
                    null);
        }

        Integer status = userRepository.updateByPassword(forgotPassword.getPassword(), forgotPassword.getPhoneNumber(), forgotPassword.getUserType());

        if (status == 0) {
            return Response.createError(false, HttpStatus.NOT_FOUND.value(), "password not changed, please try again",
                    null);
        } else {

            return Response.createSuccess(true, HttpStatus.OK.value(), "your password has been changed successfully",
                    null);

        }

    }

}
