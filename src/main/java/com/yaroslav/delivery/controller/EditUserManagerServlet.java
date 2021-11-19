package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EditUserManagerServlet")
public class EditUserManagerServlet extends HttpServlet {

    private Integer id ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        int id = Integer.parseInt(paramId);
        setId(id);
        List<User> list = new ArrayList<>();
        list.add(DBManager.selectUser(id));
        req.setAttribute("user", list);
        resp.sendRedirect("userEditForm.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = getId();

        User user = DBManager.selectUser(id);

        String name = req.getParameter("login");
        user.setLogin(name);

        String password = req.getParameter("password");
        user.setPassword(password);

        String number = req.getParameter("number");
        user.setNumber(number);

        String email = req.getParameter("email");
        user.setMail(email);

        user.setId(id);
        try {
            DBManager.updateUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("/allUserServlet");
    }

    public  Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
