package com.yaroslav.delivery.controller;

import com.yaroslav.delivery.dto.OrderDto;
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


@WebServlet("/EditOrderManagerServlet")
public class EditOrderManagerServlet extends HttpServlet {

    private final LuggageService luggageService = new LuggageService();
    private final RouteService routeService = new RouteService();
    private final OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("order", orderService.selectOrder(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("luggages", luggageService.findAllLuggage());
        req.setAttribute("routes", routeService.findAllRoute());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/orderEditForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int idOrder = Integer.parseInt(req.getParameter("idOrder"));
        int idRoute = Integer.parseInt(req.getParameter("idRoute"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        int volume = Integer.parseInt(req.getParameter("volume"));
        String way = orderService.selectWay(idRoute);
        String date = req.getParameter("date");
        String type = req.getParameter("type");
        orderService.updateOrder(new OrderDto(idRoute , way  , weight , volume , date , type , idOrder));
        resp.sendRedirect("/AllOrderServlet");
    }
}

