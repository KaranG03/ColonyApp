package com.karan.property.controller;

import com.karan.property.entity.OTPVerificationRequest;
import com.karan.property.entity.User;
import com.karan.property.repository.UserRepo;
import com.karan.property.service.EmailService;
import com.karan.property.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/verification")
@RestController
public class OtpController{

    @Autowired
    OTPService otpService;



    @PostMapping
    public ResponseEntity<?> verifyOTP(@RequestBody OTPVerificationRequest request) {
        boolean isValid = otpService.validateOTP(request.getUsername(), request.getOtp());

        if (isValid) {
            return new ResponseEntity<>("OTP verified. You can reset your password.", HttpStatus.OK);
        }

        return new ResponseEntity<>("Invalid or expired OTP.", HttpStatus.BAD_REQUEST);
    }

}
