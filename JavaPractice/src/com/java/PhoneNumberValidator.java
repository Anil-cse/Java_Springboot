package com.java;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public static void main(String[] args) {
    	String regex = "^(\\+91|0)?[789]\\d{9}$";
        String phoneNumber = "7355386415";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            System.out.println(phoneNumber + " is a valid mobile phone number");
        } else {
            System.out.println(phoneNumber + " is not a valid mobile phone number");
        }
        
        
        String regex1 = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{3,}$";
        String email = "john.kumar@hotmail.com";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(email);
        if (matcher1.matches()) {
            System.out.println(email + " is a valid email address");
        } else {
            System.out.println(email + " is not a valid email address");
        }
    }
}
