package com.yaroslav.delivery.converter;

import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.model.OrderModel;
import java.util.ArrayList;
import java.util.List;

public class OrderConverter implements Converter<OrderModel , OrderDto> , ConverterList<OrderModel , OrderDto> {
    @Override
    public OrderDto convert(OrderModel source) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(source.getId());
        orderDto.setIdUser(source.getIdUser());
        orderDto.setIdRoute(source.getIdRoute());
        orderDto.setVolume(source.getVolume());
        orderDto.setWeight(source.getWeight());
        orderDto.setPrice(source.getPrice());
        orderDto.setWay(source.getWay());
        orderDto.setPayment(source.getPayment());
        orderDto.setDate(source.getDate());
        orderDto.setType(source.getType());
        return orderDto;
    }

    @Override
    public List<OrderDto> convertList(List<OrderModel> source){

        List<OrderDto> orderDtos = new ArrayList<>();
        for (OrderModel orderModel : source) {
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

}
