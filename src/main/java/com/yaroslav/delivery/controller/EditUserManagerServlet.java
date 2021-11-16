package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.User;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EditUserManagerServlet")
public class EditUserManagerServlet extends HttpServlet {

    private static Integer id ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        int id = Integer.parseInt(paramId);
        setId(id);
        List<User> list = new ArrayList<>();
        list.add(DBManager.selectUser(id));
        req.setAttribute("user", list);
        resp.sendRedirect("userEditForm.jsp");
        System.out.println(getId());
    }

    public static Integer getId() {
        return id;
    }

    public  void setId(Integer id) {
        EditUserManagerServlet.id = id;
    }
}
