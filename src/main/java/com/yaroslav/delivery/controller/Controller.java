package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private String forward;
    private boolean flagQuery;
    private boolean flagResponse;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!flagQuery) {
            process(request, response);
        }
        flagQuery = false;
        request.getRequestDispatcher(forward).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
        if (!flagResponse) {
            flagQuery = true;
            response.sendRedirect(forward);
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String commandName = request.getParameter("command");
        Command command = CommandManager.get(commandName);
        forward = "error.jsp";
        try {
            forward = command.execute(request, response);
            flagResponse = false;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMessage", ex.getMessage());
            flagResponse = true;
            request.getRequestDispatcher(forward).forward(request, response);
        }
    }
}
