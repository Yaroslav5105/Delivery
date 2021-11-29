package com.yaroslav.delivery.validation;


public class Validation {

    private static final String emailRegex = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String filledRegex = "^\\+\\d{12}$";

    public boolean isCorrectNumber(String number) {
        return number.matches(filledRegex);
    }

    public boolean isCorrectEmail(String email) {
        if (!email.matches(emailRegex)) {
            return false;
        }
        return true;
    }
}
