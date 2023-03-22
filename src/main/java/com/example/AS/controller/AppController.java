package com.example.AS.controller;



import com.example.AS.error.ValidationException;
import com.example.AS.model.UserDetails;
import com.example.AS.model.UserDetailsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class AppController {


    // mocking comment
    @PostMapping("api/auth/signup")
    public ResponseEntity<UserDetailsResponse> post1(//@Validated
                                                         @RequestBody UserDetails userDetails)
    {


        if(userDetails.getName() == null || userDetails.getLastname() == null ||
                userDetails.getEmail() == null || userDetails.getPassword() == null ){
            //System.out.println("Error1");
           throw new ValidationException("Bad Request");
        }



        if(userDetails.getName().isBlank() || userDetails.getLastname().isBlank() ||
                userDetails.getEmail().isBlank() || userDetails.getPassword().isBlank()){
            //System.out.println("Error2");
            throw new ValidationException("Bad Request");
        }

        Pattern pattern = Pattern.compile("[a-zA-Z]{1,}\\w*@acme.com");
        Matcher matcher = pattern.matcher(userDetails.getEmail());
        if(!matcher.find()){
            //System.out.println("Error3");
            throw new ValidationException("Bad Request");
        }
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        userDetailsResponse.setName(userDetails.getName());
        userDetailsResponse.setLastname(userDetails.getLastname());
        userDetailsResponse.setEmail(userDetails.getEmail());

        return new ResponseEntity<>(userDetailsResponse, HttpStatus.OK);
    }
}
