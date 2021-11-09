package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws  IOException {
        DBManager dbManager = DBManager.getInstance("jdbc:mysql://localhost:3307/dbdelivery", "root", "19731968");

        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            writer.println(DBManager.selectAllUsers());
            writer.println(DBManager.deleteUser(1));
            writer.println(DBManager.selectUser(2));
            writer.println(DBManager.authenticate("tyrt" , " 23423"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
