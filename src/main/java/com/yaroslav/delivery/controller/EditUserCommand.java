package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUserCommand implements Command {

    private final UserService userService = new UserService();
    private static final Logger LOG = Logger.getLogger(EditUserCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        int pageId = Integer.parseInt(request.getParameter("page"));
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("login");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        try {
            userService.updateUser(new UserDto(name, password, number, email, id));
            LOG.debug("Finished executing Command");
            return "/controller?command=ListUserManager&page=" + pageId;
        } catch (Exception e) {
            LOG.error("Error in class EditUserCommand = "  , e);

            return "error.html";
        }
    }
}
