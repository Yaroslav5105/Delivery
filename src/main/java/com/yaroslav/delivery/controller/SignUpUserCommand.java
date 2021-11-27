package com.yaroslav.delivery.controller;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpUserCommand implements Command {

    private final UserService userService = new UserService();
    private final UserService creatUserService = new UserService();
    private static final Logger LOG = Logger.getLogger(SignUpUserCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("name");

        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String email = request.getParameter("mail");
        System.out.println(username);
        try {
            creatUserService.createUser(new UserDto(username, password, number, email));
            int id = userService.authenticate(email, password);
            HttpSession session = request.getSession();
            session.setAttribute("userId", id);
            LOG.debug("Finished executing Command");
            return "/IndexAuthenticateUser.jsp";

        } catch (Exception e) {
            LOG.error("Error in class SignUpUserCommand = "  , e);

            return "/error.html" ;
        }
    }
}