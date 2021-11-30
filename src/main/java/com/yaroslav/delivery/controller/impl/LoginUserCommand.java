package com.yaroslav.delivery.controller.impl;


import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUserCommand implements Command {

    private final UserService creatUserService = new UserService();
    private static final Logger LOG = Logger.getLogger(LoginUserCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");
        request.setCharacterEncoding("UTF-8");
        int pageId = Integer.parseInt(request.getParameter("page"));
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String email = request.getParameter("mail");

        try {
            creatUserService.createUser(new UserDto(username, password, number, email));
            response.setCharacterEncoding("UTF-8");
            LOG.debug("Finished executing Command");
            LOG.debug("Finished executing Command");
            return "/controller?command=ListUserManager&page=" + pageId;
        } catch (Exception e) {
            LOG.error("Error in class LoginUserCommand = "  , e);

            return "error.html";
        }
    }
}