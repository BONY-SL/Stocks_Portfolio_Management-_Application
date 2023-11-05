package com.example.spms.Validate;

public class MailValidate {

    public static boolean isValidEmail(String email) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);

    }

}
