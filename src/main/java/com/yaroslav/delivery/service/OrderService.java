package com.yaroslav.delivery.service;

import com.yaroslav.delivery.converter.OrderConverter;
import com.yaroslav.delivery.dao.OrderDao;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.model.OrderModel;

import java.sql.SQLException;
import java.util.List;


public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private OrderModel orderModel = new OrderModel();
    private OrderConverter converter = new OrderConverter();

    public boolean createOrder(OrderDto creatOrder) {
        try {
           return orderDao.insertOrder(orderModel.creatOrder(creatOrder.getIdUser(), creatOrder.getIdRoute(), creatOrder.getVolume(), creatOrder.getWeight(), "not paid", creatOrder.getDate(), creatOrder.getType()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public int countOrder(OrderDto orderDto) {
        return (orderDto.getVolume() + orderDto.getWeight()) * 2 + orderDto.getIdRoute() * 4;
    }

    public boolean delete(int delete) {
        try {
           return orderDao.deleteOrder(delete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return false;
    }

    public OrderDto selectOrder(int id) {
        return converter.convert(orderDao.selectOrder(id));
    }


    public boolean updateOrder(OrderDto orderDto) {

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
        return true;
    }

    public boolean payment(OrderDto orderDto) {
        OrderModel orderModel = orderDao.selectOrder(orderDto.getId());

        orderModel.setId(orderDto.getId());
        orderModel.setPayment("successful payment");

        try {
            return orderDao.updatePayment(orderModel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<OrderDto> findAllOrdersByUserId(int iduser) {
        return converter.convertList(orderDao.selectOrdersByUser(iduser));
    }

    public List<OrderDto> findAllOrders(int start) {

        int total = 5;
        if (start != 1) {
            start = start - 1;
            start = start * total + 1;
        }
        return converter.convertList(orderDao.selectOrders(start, total));
    }

    public OrderDto findUserByIdOrder(int idOrder) {
        return converter.convert(orderDao.selectUserByIdOrder(idOrder));
    }

    public List<OrderDto> findOrderFromSmallerSort(int start) {
        int total = 5;
        if (start != 1) {
            start = start - 1;
            start = start * total + 1;
        }
        return converter.convertList(orderDao.selectOrderSortFromSmaller(start, total));
    }

    public List<OrderDto> findOrderFromLargerSort(int start) {
        int total = 5;
        if (start != 1) {
            start = start - 1;
            start = start * total + 1;
        }
        return converter.convertList(orderDao.selectOrderSortFromLarger(start, total));
    }


    public List<OrderDto> findAllOrderByPriceAndWay(int price , String way) {
        return converter.convertList(orderDao.selectOrderByWay(price, way));
    }

}
