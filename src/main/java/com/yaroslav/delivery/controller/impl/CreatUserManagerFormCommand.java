package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreatUserManagerFormCommand implements Command {
    private static final Logger LOG = Logger.getLogger(CreatUserManagerFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                if (error.equals("number")) {
                    request.setAttribute("errorMessage", "a warning ! wrong phone number format");
                }
                if (error.equals("email")) {
                    request.setAttribute("errorMessage", "a warning ! wrong email format");
                }
            }

            request.setAttribute("pageId", Integer.parseInt(request.getParameter("idpage")));
            LOG.debug("Finished executing Command");
            return "/adduser.jsp";
        } catch (Exception e) {
            LOG.error("Error in class dataForCreatUserManagerCommand = "  , e);
            return "error.html";
        }
    }
}