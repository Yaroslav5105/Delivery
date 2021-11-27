package com.yaroslav.delivery.service;

import com.yaroslav.delivery.converter.UserConverter;
import com.yaroslav.delivery.dao.UserDao;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.model.UserModel;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();
    private final UserModel userModel = new UserModel();
    private final UserConverter userConverter = new UserConverter();

    public void createUser(UserDto createUserDto) {

        String username = createUserDto.getLogin();
        String password = createUserDto.getPassword();
        String number = createUserDto.getNumber();
        String mail = createUserDto.getEmail();

        try {
            userDao.insertUser(userModel.createUser(username, password, number, mail));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<UserDto> findAllUsers(int start) {
        int total = 5;
        if (start != 1) {
            start = start - 1;
            start = start * total + 1;
        }
        return userConverter.convertList(userDao.selectUsers(start, total));
    }

    public void updateUser(UserDto userDto) {
        UserModel userModel = userDao.selectUser(userDto.getId());

        userModel.setLogin(userDto.getLogin());
        userModel.setMail(userDto.getEmail());
        userModel.setNumber(userDto.getNumber());
        userModel.setPassword(userDto.getPassword());
        userModel.setId(userDto.getId());

        try {
            userDao.updateUser(userModel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public UserDto selectUser(int id) {
        if (userDao.selectUser(id).getMail() != null) {
            return userConverter.convert(userDao.selectUser(id));
        }
        return new UserDto();
    }


    public void delete(int id) {
        try {
            userDao.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public UserDto selectUserByEmail(String email) {
        return userConverter.convert(userDao.selectUserByEmail(email));
    }

    public int authenticate(String email, String password) {
        int userId = 0;
        userId = userDao.selectUserAuthenticate(email, password);
        return userId;
    }

    public String page(int id, String email, String password) {

        if (email.equals("admin@gmail.com")) {
            if (password.equals("12345"))
                return "maneger.jsp";
        } else if (id != 0) {
            return "IndexAuthenticateUser.jsp";
        }
        return "index.jsp";
    }

    public String pageDataUser(int id) {
        if (selectUser(id).getEmail() != null) {
            return "/findOrdersByUserId.jsp";
        } else return "errorNotFoundUser.jsp";
    }

    public String pageDataOrder(int id) {

        if (selectUser(id).getId() != null) {
            return "/findOrder.jsp";
        } else return "errorNotFoundUser.jsp";
    }
}