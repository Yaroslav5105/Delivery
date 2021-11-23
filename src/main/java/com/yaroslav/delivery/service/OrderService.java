package com.yaroslav.delivery.service;

import com.yaroslav.delivery.converter.OrderConverter;
import com.yaroslav.delivery.dao.OrderDao;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.model.OrderModel;
import java.sql.SQLException;
import java.util.List;


public class OrderService {
    private final OrderDao orderDao = new OrderDao();
    private final OrderModel orderModel = new OrderModel();
    private final OrderConverter converter = new OrderConverter();

    public void createOrder(OrderDto creatOrder) {

        String date = creatOrder.getDate();
        String type = creatOrder.getType();
        int idRoute = creatOrder.getIdRoute();
        int volume = creatOrder.getVolume();
        int weight = creatOrder.getWeight();
        int idUser = creatOrder.getIdUser();
        String payment = "not paid";
        try {
            orderDao.insertOrder(orderModel.creatOrder(idUser, idRoute, volume, weight, payment, date, type));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int countOrder(OrderDto orderDto) { return (orderDto.getVolume() + orderDto.getWeight()) * 2 + orderDto.getIdRoute() * 4; }

    public void delete(int delete) {
        try {
            orderDao.deleteOrder(delete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public OrderDto selectOrder(int id) { return converter.convert(orderDao.selectOrder(id)); }


    public void updateOrder(OrderDto orderDto) {

        OrderModel orderModel = orderDao.selectOrder(orderDto.getId());
        orderModel.setIdRoute(orderDto.getIdRoute());
        orderModel.setWay(orderDto.getWay());
        orderModel.setWeight(orderDto.getWeight());
        orderModel.setVolume(orderDto.getVolume());
        orderModel.setDate(orderDto.getDate());
        orderModel.setType(orderDto.getType());
        orderModel.setId(orderDto.getId());
        try {
            orderDao.updateOrder(orderModel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void payment(OrderDto orderDto) {
        OrderModel orderModel = orderDao.selectOrder(orderDto.getId());
        orderModel.setId(orderDto.getId());
        orderModel.setPayment("successful payment");

        try {
            orderDao.updatePayment(orderModel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<OrderDto> findAllOrdersByUserId(int iduser) { return converter.convertList(orderDao.selectOrdersByUser(iduser)); }

    public List<OrderDto> findAllOrders(int start) {

        int total=5;
        if(start!=1) {
            start = start - 1;
            start = start * total + 1;
        }
        return converter.convertList(orderDao.selectOrders( start, total));
    }

}
