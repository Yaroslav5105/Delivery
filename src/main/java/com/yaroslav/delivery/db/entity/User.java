package com.yaroslav.delivery.db.entity;

public class User {

    private Integer id;
    private static String login;
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

    public void setMail(String mail) {
        this.email = mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        User.login = login;
    }

    public static User createUser(String login , String password  , String number , String mail) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setMail(mail);
        user.setNumber(number);
        return user;
    }

    public  User (String login , String password  , String number , String email) {
        super();
        this.login = login;
        this.email = email;
        this.number = number;
        this.password = password;

    }

    public User(){}

    public User  (int id , String login , String password  , String number , String email) {
        super();
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof User) {
            return true;
        }
        User other = (User) obj;
        if (login == null) {
            return other.login == null;
        } else return login.equals(other.login);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return login;
    }



}