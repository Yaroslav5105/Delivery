package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SortIdUserforlargerCommand implements Command {

    private final UserService userService = new UserService();
    private static final Logger LOG = Logger.getLogger(SortIdUserforlargerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");
        try {
            int pageid = Integer.parseInt(request.getParameter("page"));
            request.setAttribute("page", pageid);
            request.setAttribute("sort" , userService.sortIdUserforLarger(pageid));
            LOG.debug("Finished executing Command");
            return "sortIdUserForLarger.jsp" ;
        } catch (Exception e) {
            return "error.html";
        }
    }
}
