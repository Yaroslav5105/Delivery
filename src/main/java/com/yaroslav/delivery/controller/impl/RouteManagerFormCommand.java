package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RouteManagerFormCommand implements Command {
    private static final Logger LOG = Logger.getLogger(RouteManagerCommand.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                if (error.equals("word")) {
                    request.setAttribute("errorMessage", "a warning ! only word in way!");
                }
                if (error.equals("kilometer")) {
                    request.setAttribute("errorWord", "a warning ! only number in kilometer");
                }
            }
            return "routeManager.jsp";
        }catch (Exception e){
            LOG.error("Error in class RouteManagerCommand = "  , e);

            return "error.jsp";
        }
    }
}
