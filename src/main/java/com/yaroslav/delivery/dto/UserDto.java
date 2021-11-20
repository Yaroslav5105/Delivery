package com.yaroslav.delivery.dto;

public class UserDto {

    private Integer id;
    private String login;
    private String password;
    private String number;
    private String email;

    public UserDto() {
    }

    public UserDto(String login , String password , String number , String email , Integer id){
        setLogin(login);
        setPassword(password);
        setNumber(number);
        setEmail(email);
        setId(id);
    }
    public UserDto(String name, String password, String number, String email) {
        setLogin(name);
        setNumber(number);
        setEmail(email);
        setPassword(password);
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
