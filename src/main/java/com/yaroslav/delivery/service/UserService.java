package com.yaroslav.delivery.service;

import com.yaroslav.delivery.converter.InterfaceListOrder;
import com.yaroslav.delivery.converter.UserConverter;
import com.yaroslav.delivery.dao.UserDao;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.model.UserModel;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();
    private UserModel userModel = new UserModel();
    private UserConverter userConverter = new UserConverter();

    public boolean createUser(UserDto createUserDto) {

        String username = createUserDto.getLogin();
        String password = createUserDto.getPassword();
        String number = createUserDto.getNumber();
        String mail = createUserDto.getEmail();

        try {

            return userDao.insertUser(userModel.createUser(username, password, number, mail));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<UserDto> findAllUsers(int start) {
        InterfaceListOrder interfaces;
        int total = 5;
        if (start != 1) {
            interfaces = (star) -> (star - 1) * total + 1;
            start = interfaces.listOrder(start);
        }
        return userConverter.convertList(userDao.selectUsers(start, total));
    }

    public boolean updateUser(UserDto userDto) {
        UserModel userModel = userDao.selectUser(userDto.getId());

        userModel.setLogin(userDto.getLogin());
        userModel.setMail(userDto.getEmail());
        userModel.setNumber(userDto.getNumber());
        userModel.setPassword(userDto.getPassword());
        userModel.setId(userDto.getId());

        try {
            return userDao.updateUser(userModel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public UserDto selectUser(int id) {
        if (userDao.selectUser(id).getMail() != null) {
            return userConverter.convert(userDao.selectUser(id));
        }
        return new UserDto();
    }


    public boolean delete(int id) {
        try {
            return userDao.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    public UserDto selectUserByEmail(String email) {
        return userConverter.convert(userDao.selectUserByEmail(email));
    }

    public int authenticate(String email, String password) {
        int userId = 0;
        userId = userDao.selectUserAuthenticate(email, password);
        return userId;
    }

    public List<UserDto> sortIdUserforLarger(int start) {
        int total = 5;
        if (start != 1) {
            start = start - 1;
            start = start * total + 1;
        }
        return userConverter.convertList(userDao.sortIdUserForLarger(start, total));
    }
}