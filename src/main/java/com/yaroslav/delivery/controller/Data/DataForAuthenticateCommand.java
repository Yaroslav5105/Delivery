package com.yaroslav.delivery.controller.Data;

import com.yaroslav.delivery.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataForAuthenticateCommand implements Command {
    private static final Logger LOG = Logger.getLogger(DataForAuthenticateCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                if (error.equals("notFind")) {
                    request.setAttribute("errorMessage", "Incorrect login or password\n");
                }
            }
            return "LogIn.jsp";
        } catch (Exception e) {
            LOG.error("Error in class DataForAuthenticateCommand = ", e);
            return "error.html";
        }
    }
}