package com.yaroslav.delivery.controller.impl;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;

import com.yaroslav.delivery.validation.UserValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpUserCommand implements Command {
    private final UserService userService = new UserService();
    private final UserService creatUserService = new UserService();
    private static final Logger LOG = Logger.getLogger(SignUpUserCommand.class);
    private final UserValidator userValidator = new UserValidator();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");
        request.setCharacterEncoding("UTF-8");

        String username = "";
        String email = "";
        String password = "";
        String number = "";


        if (request.getParameter("number") != null && request.getParameter("password") != null && request.getParameter("name") != null && request.getParameter("mail") != null) {
            email = request.getParameter("mail");
            username = request.getParameter("name");
            password = request.getParameter("password");
            number = request.getParameter("number");
        }

        if (!userValidator.validateUserNumber(number)) {
            return "controller?command=dataFotCrearteUser&error=wrongNumber";
        }

        try {
            if (!email.equals("")) {
                if (userValidator.validateEmail(email)) {
                    UserDto userDto = new UserDto(username, password, number, email);
                    int id = createUser(userDto);
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", id);

                    return "/IndexAuthenticateUser.jsp";
                } else {
                    LOG.error("Wrong email");
                    return "controller?command=dataFotCrearteUser&error=wrongEmail";
                }
            }
        } catch (Exception e) {
            LOG.error("Error in class SignUpUserCommand = ", e);
        }
        return "/error.html";
    }

    public int createUser(UserDto user) {
        try {
            creatUserService.createUser(user);
            int id = userService.authenticate(user.getEmail(), user.getPassword());

            LOG.debug("Finished executing Command");
            return id;
        } catch (Exception e) {
            LOG.error("Error in class SignUpUserCommand = ", e);
        }
        return 0;
    }
}
