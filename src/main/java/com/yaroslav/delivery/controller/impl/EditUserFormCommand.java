package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUserFormCommand implements Command {

    private final UserService userService = new UserService();
    private static final Logger LOG = Logger.getLogger(EditUserFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {

            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                if (error.equals("wrongNumber")) {
                    request.setAttribute("errorMessage", "a warning ! wrong phone number format");
                }
            }
            request.setAttribute("pageId", Integer.parseInt(request.getParameter("idpage")));
            request.setAttribute("user", userService.selectUser(Integer.parseInt(request.getParameter("id"))));
            LOG.debug("Finished executing Command");
            return "/userEditForm.jsp" ;
        } catch (Exception e) {
            LOG.error("Error in class dataForEditUserCommand = "  , e);
            return "error.html";
        }
    }
}
