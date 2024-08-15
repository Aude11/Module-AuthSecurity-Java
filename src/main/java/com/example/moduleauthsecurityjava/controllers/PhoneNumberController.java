package com.example.moduleauthsecurityjava.controllers;

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
        return "Not a valid phone number format";
    }

    private boolean isValidPhoneNumber (String phoneNumber) {
        if(phoneNumber == null) return false;
        if (phoneNumber.length() != PHONE_NUMBER_LENGTH ) return false;
        if (phoneNumber.matches("[0-9]+")) return true;
        return false;
    }
}
