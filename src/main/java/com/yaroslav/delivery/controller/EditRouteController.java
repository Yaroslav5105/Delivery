package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.service.LuggageService;
import com.yaroslav.delivery.service.OrderService;
import com.yaroslav.delivery.service.RouteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/EditRouteController")
public class EditRouteController extends HttpServlet {

    private final RouteService routeService = new RouteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("route", routeService.selectRoute(Integer.parseInt(req.getParameter("id"))));
            req.setAttribute("idroute", Integer.parseInt(req.getParameter("id")));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/routeEditForm.jsp");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Error select route");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String way = req.getParameter("way");
        int kilometers = Integer.parseInt(req.getParameter("kilometers"));
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            routeService.update(new RouteDto(id, way, kilometers));
            resp.sendRedirect("/ListRouteManagerController");
        } catch (Exception e) {
            req.setAttribute("message", "Error update route");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
