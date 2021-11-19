package com.yaroslav.delivery.service;

import com.yaroslav.delivery.dao.UserDAO;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.model.UserModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public void createUser(UserDto creatUserDto) {

        String username = creatUserDto.getLogin();
        String password = creatUserDto.getPassword();
        String number = creatUserDto.getNumber();
        String mail = creatUserDto.getEmail();

        try {
            userDAO.insertUser(UserModel.createUser(username, password, number, mail));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<UserDto> findAllUser() {

        List<UserDto> userDtos = new ArrayList<>();

        List<UserModel> userModels = userDAO.findAllUsers();
        for (UserModel userModel : userModels) {
            UserDto userDto = new UserDto();
            userDtos.add(userDto);
            userDto.setId(userModel.getId());
            userDto.setLogin(userModel.getLogin());
            userDto.setPassword(userModel.getPassword());
            userDto.setNumber(userModel.getNumber());
            userDto.setEmail(userModel.getMail());
        }
        return userDtos;
    }
}