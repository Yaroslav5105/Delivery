package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUsersManagerCommand implements Command {

    private final UserService findAllUsers = new UserService();
    private static final Logger LOG = Logger.getLogger(ListUsersManagerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");
        try {

            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                if (error.equals("number")) {
                    request.setAttribute("errorMessage", "a warning ! only numbers");
                }
                if (error.equals("notId")) {
                    request.setAttribute("errorMessage", "a warning ! there is no such client in the database");
                }
            }

            int pageid = Integer.parseInt(request.getParameter("page"));
            request.setAttribute("page", pageid);
            request.setAttribute("listUsers", findAllUsers.findAllUsers(pageid));
            LOG.debug("Finished executing Command");
            return "/managerListUser.jsp";
        } catch (Exception e) {
            LOG.error("Error in class ListUsersManagerCommand = "  , e);

            return "error.html";
        }
    }
}