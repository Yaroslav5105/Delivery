package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/EditUserManagerServlet")
public class EditUserManagerServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("user", userService.selectUser(Integer.parseInt(req.getParameter("id"))));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userEditForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("login");
        String password = req.getParameter("password");
        String number = req.getParameter("number");
        String email = req.getParameter("email");
        userService.updateUser(new UserDto(name , password , number , email , id));
        resp.sendRedirect("/allUserServlet");
    }

}
