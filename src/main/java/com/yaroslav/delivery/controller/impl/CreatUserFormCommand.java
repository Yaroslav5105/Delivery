package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreatUserFormCommand implements Command {

    private static final Logger LOG = Logger.getLogger(CreatUserFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                    if (error.equals("dublicateLogin")) {
                        request.setAttribute("errorMessage", "This login is already in use");
                    }
                    if (error.equals("wrongNumber")) {
                        request.setAttribute("Message", "Incorrect number, try again");
                    }
                    if (error.equals("wrongEmail")) {
                        request.setAttribute("error", "Incorrect email, try again");
                    }
            }
            return "signUp.jsp";
        } catch (Exception e) {
            LOG.error("Error in class DataForCreatUserCommand = ", e);
            return "error.html";
        }
    }
}