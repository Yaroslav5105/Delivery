package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreatUserFormCommand implements Command {

    private static final Logger LOG = Logger.getLogger(CreatUserFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");
                String errorNumber = request.getParameter("errorNumber");
                String errorEmail = request.getParameter("errorEmail");

                if (error.equals("wrongName")) {
                    request.setAttribute("wrongName", "Incorrect name, try again");
                }
                if (errorNumber.equals("wrongNumber")) {
                    request.setAttribute("wrongNumber", "Incorrect number, try again");
                }
                if (errorEmail.equals("wrongEmail")) {
                    request.setAttribute("errorEmail", "Incorrect email, try again");
                }

            }
            LOG.debug("Finished executing Command");
            return "signUp.jsp";
        } catch (Exception e) {
            LOG.error("Error in class DataForCreatUserCommand = ", e);
            return "error.html";
        }
    }
}