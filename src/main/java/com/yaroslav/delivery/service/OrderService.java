package com.yaroslav.delivery.service;

import com.yaroslav.delivery.dao.OrderDAO;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.model.OrderModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderService {
    OrderDAO orderDAO = new OrderDAO();
    OrderModel orderModel = new OrderModel();

    public void createOrder(OrderDto creatOrder) {

        String date = creatOrder.getDate();
        String type = creatOrder.getType();
        int idRoute = creatOrder.getIdRoute();
        int volume = creatOrder.getVolume();
        int weight = creatOrder.getWeight();
        int idUser = creatOrder.getIdUser();
        String payment = "not paid";
        try {
            orderDAO.insertOrder(orderModel.creatOrder(idUser, idRoute, volume, weight, payment, date, type));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<OrderDto> findAllOrder() {

        List<OrderDto> orderDtos = new ArrayList<>();
        List<OrderModel> orderModels = orderDAO.findAllOrder();
        for (OrderModel orderModel : orderModels) {
            OrderDto orderDto = new OrderDto();
            orderDtos.add(orderDto);
            orderDto.setId(orderModel.getId());
            orderDto.setIdUser(orderModel.getIdUser());
            orderDto.setIdRoute(orderModel.getIdRoute());
            orderDto.setVolume(orderModel.getVolume());
            orderDto.setWeight(orderModel.getWeight());
            orderDto.setPrice(orderModel.getPrice());
            orderDto.setWay(orderModel.getWay());
            orderDto.setPayment(orderModel.getPayment());
            orderDto.setDate(orderModel.getDate());
            orderDto.setType(orderModel.getType());
        }
        return orderDtos;
    }

    public int countOrder(OrderDto orderDto) {
        return (orderDto.getVolume() + orderDto.getWeight()) * 2 + orderDto.getIdRoute() * 4;
    }

    public void delete(int delete) {
        try {
            orderDAO.delete(delete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public OrderDto selectOrder(int id) {

        OrderDto orderDto = new OrderDto();
        OrderModel selectorderModel = orderDAO.selectOrder(id);
        orderDto.setId(selectorderModel.getId());
        orderDto.setIdUser(selectorderModel.getIdUser());
        orderDto.setIdRoute(selectorderModel.getIdRoute());
        orderDto.setVolume(selectorderModel.getVolume());
        orderDto.setWeight(selectorderModel.getWeight());
        orderDto.setPrice(selectorderModel.getPrice());
        orderDto.setWay(selectorderModel.getWay());
        orderDto.setPayment(selectorderModel.getPayment());
        orderDto.setDate(selectorderModel.getDate());
        orderDto.setType(selectorderModel.getType());

        return orderDto;
    }

    public String selectWay(int i) {
        return orderDAO.selectWay(i);
    }

    public void updateOrder(OrderDto orderDto) {
        OrderModel orderModel = orderDAO.selectOrder(orderDto.getId());
        orderModel.setIdRoute(orderDto.getIdRoute());
        orderModel.setWay(orderDto.getWay());
        orderModel.setWeight(orderDto.getWeight());
        orderModel.setVolume(orderDto.getVolume());
        orderModel.setDate(orderDto.getDate());
        orderModel.setType(orderDto.getType());
        orderModel.setId(orderDto.getId());
        try {
            orderDAO.updateOrder(orderModel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void payment(OrderDto orderDto) {
        OrderModel orderModel = orderDAO.selectOrder(orderDto.getIdRoute());
        orderModel.setId(orderDto.getId());
        orderModel.setPayment("successful payment");

        try {
            orderDAO.payment(orderModel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<OrderDto> findAllOrderByUserId(int iduser) {
        List<OrderDto> orderDtos = new ArrayList<>();
        List<OrderModel> orderModel = orderDAO.findAllOrderByUsers(iduser);
        for (OrderModel order : orderModel) {
            OrderDto orderDto = new OrderDto();
            orderDtos.add(orderDto);
            orderDto.setIdUser(iduser);
            orderDto.setId(order.getId());
            orderDto.setWay(order.getWay());
            orderDto.setVolume(order.getVolume());
            orderDto.setWeight(order.getWeight());
            orderDto.setPrice(order.getPrice());
            orderDto.setPayment(order.getPayment());
            orderDto.setDate(order.getDate());
            orderDto.setType(order.getType());
        }
        return orderDtos;
    }
}
