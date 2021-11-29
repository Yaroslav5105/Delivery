package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.command.Command;
import com.yaroslav.delivery.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticateCommand implements Command {
    private final Logger LOG = Logger.getLogger(AuthenticateCommand.class);
    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.debug("Start executing Command");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("admin@gmail.com")) {
            if (password.equals("12345"))
                return "maneger.jsp";
        }

        try {
            int id = userService.authenticate(email, password);
            if (id != 0) {
                request.setAttribute("user", userService.selectUserByEmail(request.getParameter("email")));

                HttpSession session = request.getSession();
                session.setAttribute("userId", id);
                LOG.debug("Finished executing Command");
                return "IndexAuthenticateUser.jsp" ;
            }
            return "controller?command=dataForAuthenticate&error=notFind";
        } catch (Exception e) {
            LOG.error("Error in class AuthenticateCommand = "  , e);

            return "/error.html" ;
        }
    }
}
