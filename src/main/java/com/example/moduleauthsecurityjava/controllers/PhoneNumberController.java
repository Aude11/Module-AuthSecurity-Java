package com.example.moduleauthsecurityjava.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.moduleauthsecurityjava.models.PhoneNumberRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {

    int PHONE_NUMBER_LENGTH = 11;

    @PostMapping("/phone-number")
    public String phoneNumberSubmit(@ModelAttribute PhoneNumberRequest request) {
        if (isValidPhoneNumber(request.getPhone())) {
            System.out.println("\033[96mThe user submitted the phone number: " + request.getPhone() + "\033[0m");
            return "Successful!";
        }
        return String.valueOf(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    private boolean isValidPhoneNumber (String phoneNumber) {
        if(phoneNumber == null) {
            System.out.println("\033[96mEmpyt or null phone number provided" + "\033[0m");
            return false;
        }
        if (phoneNumber.length() != PHONE_NUMBER_LENGTH ) {
            System.out.println("\033[96mInvalid lenght phone number format provided" + "\033[0m");
            return false;
        }
        if (phoneNumber.matches("[0-9]+")) {
            return true;
        }
        System.out.println("\033[96mInvalid phone number format provided" + "\033[0m");
        return false;
    }
}
