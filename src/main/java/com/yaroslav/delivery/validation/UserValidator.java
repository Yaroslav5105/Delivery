package com.yaroslav.delivery.validation;

public class UserValidator  {

    private final Validation validation = new Validation();

    public boolean validateUserNumber(String number) {
        return validation.isCorrectNumber(number);
    }

    public boolean validateEmail(String email) {
        return validation.isCorrectEmail(email);
    }
}
