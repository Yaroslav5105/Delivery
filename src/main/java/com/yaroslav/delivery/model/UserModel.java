package com.yaroslav.delivery.model;


public class UserModel {

    private Integer id;
    private String login;
    private String password ;
    private String number ;
    private String email ;

    public int getId() {
        return id;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserModel createUser(String login , String password  , String number , String mail) {
        UserModel user = new UserModel();
        user.setLogin(login);
        user.setPassword(password);
        user.setMail(mail);
        user.setNumber(number);
        return user;
    }

    public UserModel(){}

    public UserModel  (int id , String login , String password  , String number , String email) {

        this.id = id;
        this.login = login;
        this.email = email;
        this.number = number;
        this.password = password;
    }
    public String getPassword () {
        return password ;
    }

    public void setPassword (String paaword) {
        this.password  = paaword;
    }


}

