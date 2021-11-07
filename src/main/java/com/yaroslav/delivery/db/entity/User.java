package com.yaroslav.delivery.db.entity;

public class User {

    private Integer id;
    private String login;

    public int getId() {
        return id;
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

    public static User createUser(String login) {
        User user = new User();
        user.setLogin(login);
        return user;
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