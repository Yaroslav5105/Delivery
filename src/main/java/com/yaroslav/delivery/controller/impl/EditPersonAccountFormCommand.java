package com.yaroslav.delivery.controller.impl;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditPersonAccountFormCommand implements Command {

    private final UserService userService = new UserService();
    private static final Logger LOG = Logger.getLogger(EditPersonAccountFormCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        try {
            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");

                if (error.equals("wrongNumber")) {
                    request.setAttribute("errorMessage", "a warning ! wrong phone number format");
                }
                if (error.equals("wrongName")) {
                    request.setAttribute("error", "a warning ! wrong name format , only word");
                }
            }
            if (request.getParameter("info") != null) {
                String error = request.getParameter("info");

                if (error.equals("ok")) {
                    request.setAttribute("successfully", "successfully modified");
                }

            }
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            if(userId == 0){
                userId = Integer.parseInt(request.getParameter("id"));
            }
            request.setAttribute("user", userService.selectUser(userId));
            LOG.debug("Finished executing Command");
            return "personalAccountController.jsp";
        } catch (Exception e) {
            LOG.error("Error in class dataEditPersonAccountCommand = "  , e);
            return "error.jsp";
        }
    }
}
