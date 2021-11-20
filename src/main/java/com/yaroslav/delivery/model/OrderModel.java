package com.yaroslav.delivery.model;

import com.yaroslav.delivery.db.entity.Order;

public class OrderModel {
    private Integer id;
    private Integer idUser;
    private Integer idRoute;
    private Integer volume;
    private Integer weight;
    private Integer price ;
    private String way ;
    private String payment;
    private String date ;
    private String type ;

    public OrderModel(){}

    public OrderModel (Integer id , Integer idUser ,String way  , Integer volume , Integer weight , String date , String type){
        super();
        this.id = id;
        this.idUser = idUser;
        this.way = way;
        this.volume = volume;
        this.weight = weight;
        this.date = date;
        this.type = type ;
    }

    public OrderModel creatOrder(Integer idUser , Integer idRoute  , Integer volume , Integer weight , String payment , String date , String type){
        OrderModel orderModel = new OrderModel();
        orderModel.setIdUser(idUser);
        orderModel.setIdRoute(idRoute);
        orderModel.setVolume(volume);
        orderModel.setWeight(weight);
        orderModel.setPayment(payment);
        orderModel.setDate(date);
        orderModel.setType(type);
        return orderModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) { this.idRoute = idRoute; }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public  Integer getPrice() { return price;  }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
