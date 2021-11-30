package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteUserCommand implements Command {
    private static final Logger LOG = Logger.getLogger(DeleteUserCommand.class);

    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        int pageId = Integer.parseInt(request.getParameter("idpage"));
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userService.delete(id);
            LOG.debug("Finished executing Command");
            return "/controller?command=ListUserManager&page=" + pageId;
        } catch (Exception e) {
            LOG.error("Error in class DeleteUserCommand = "  , e);

            return "error.html";
        }
    }
}
