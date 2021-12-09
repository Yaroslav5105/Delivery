package com.yaroslav.delivery.validation;


public class Validation {

    private static final String email = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String number = "^\\+\\d{12}$";
    private static final String word = "^[a-zA-Zа-яА-ЯёЁїЇіІ]+$";
    private static final String kilometer = "^[0-9]+$";

    public boolean isCorrectNumber(String number) {
        return number.matches(Validation.number);
    }

    public boolean isCorrectEmail(String email) {
        return email.matches(Validation.email);
    }

    public boolean isCorrectWord(String word) {
        return word.matches(Validation.word);
    }

    public boolean isCorrectkilometer(String kilometer) {
        return kilometer.matches(Validation.kilometer);
    }

}
