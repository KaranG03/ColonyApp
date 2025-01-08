package com.karan.property.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OTPService {

    private final Map<String, String> otpData = new HashMap<>();
    private final Map<String, Long> otpExpiry = new HashMap<>();
    private static final long OTP_VALIDITY_PERIOD = 5 * 60 * 1000; // 5 minutes

    public String generateOTP(String username) {
        String otp = String.valueOf((int) (Math.random() * 9000) + 1000); // Generate 4-digit OTP
        otpData.put(username, otp);
        otpExpiry.put(username, System.currentTimeMillis() + OTP_VALIDITY_PERIOD);
        return otp;
    }

    public boolean validateOTP(String username, String otp) {
        if (!otpData.containsKey(username)) return false;

        // Check OTP validity and expiration
        String validOtp = otpData.get(username);
        long expiryTime = otpExpiry.get(username);

        if (System.currentTimeMillis() > expiryTime) {
            otpData.remove(username); // Expire OTP
            otpExpiry.remove(username);
            return false;
        }

        return validOtp.equals(otp);
    }
}
