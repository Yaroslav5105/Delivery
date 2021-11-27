package com.yaroslav.delivery.controller.Date;

import com.yaroslav.delivery.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dataForCreatUserManagerCommand implements Command {
    private static final Logger LOG = Logger.getLogger(dataForCreatUserManagerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            request.setAttribute("pageId", Integer.parseInt(request.getParameter("idpage")));
            LOG.debug("Finished executing Command");
            return "/adduser.jsp";
        } catch (Exception e) {
            LOG.error("Error in class dataForCreatUserManagerCommand = "  , e);
            return "error.html";
        }
    }
}