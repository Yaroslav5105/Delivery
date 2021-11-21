package com.yaroslav.delivery.service;

import com.yaroslav.delivery.dao.UserDAO;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.model.UserModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();
    private final UserModel userModel = new UserModel();

    public void createUser(UserDto createUserDto) {

        String username = createUserDto.getLogin();
        String password = createUserDto.getPassword();
        String number = createUserDto.getNumber();
        String mail = createUserDto.getEmail();

        try {
            userDAO.insertUser(userModel.createUser(username, password, number, mail));
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

    public void updateUser(UserDto userDto) {
        UserModel userModel = userDAO.selectUser(userDto.getId());

        userModel.setLogin(userDto.getLogin());
        userModel.setMail(userDto.getEmail());
        userModel.setNumber(userDto.getNumber());
        userModel.setPassword(userDto.getPassword());
        userModel.setId(userDto.getId());

        try {
            userDAO.updateUser(userModel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public UserDto selectUser(int id) {
        UserDto userDto = new UserDto();
        UserModel userModel = userDAO.selectUser(id);

        userDto.setEmail(userModel.getMail());
        userDto.setNumber(userDto.getNumber());
        userDto.setPassword(userModel.getPassword());
        userDto.setLogin(userModel.getLogin());
        userDto.setId(userModel.getId());
        return userDto;
    }

    public void delete(int id) {
        try {
            userDAO.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public UserDto selectUserByEmail(String email) {
        UserDto userDto = new UserDto();

        UserModel userModel = userDAO.selectUserByEmail(email);

        userDto.setId(userModel.getId());

        return userDto;
    }

    public int authenticate(String email, String password) {
        int userId = 0;
        try {
            userId = userDAO.authenticate(email, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
}