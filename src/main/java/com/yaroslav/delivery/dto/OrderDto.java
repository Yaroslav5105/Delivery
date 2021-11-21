package com.yaroslav.delivery.dto;

import com.yaroslav.delivery.controller.OrderServlet;
import com.yaroslav.delivery.db.entity.Order;
import com.yaroslav.delivery.service.OrderService;

public class OrderDto {

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

    public OrderDto(Integer id ){
        setId(id);
        setIdRoute(idRoute);
    }

    public OrderDto(Integer idRoute , String way , Integer weight , Integer volume , String date , String type , Integer id) {
        setIdRoute(idRoute);
        setWeight(weight);
        setWay(way);
        setVolume(volume);
        setDate(date);
        setId(id);
        setType(type);
    }

    public OrderDto (){}
    public OrderDto(Integer idRoute , Integer volume  , Integer weight){
        setIdRoute(idRoute);
        setVolume(volume);
        setWeight(weight);
    }

    public OrderDto (Integer idUser , Integer idRoute  , Integer volume , Integer weight  , String date , String type){

        setIdUser(idUser);
        setIdRoute(idRoute);
        setVolume(volume);
        setWeight(weight);
        setDate(date);
        setType(type);
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

