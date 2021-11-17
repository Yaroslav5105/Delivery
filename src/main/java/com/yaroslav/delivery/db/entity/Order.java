package com.yaroslav.delivery.db.entity;

public class Order {
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

    public Order(){}

    public  Order (Integer id , Integer idUser ,String way  , Integer volume , Integer weight ){
        super();
        this.id = id;
        this.idUser = idUser;
        this.way = way;
        this.volume = volume;
        this.weight = weight;
    }

    public static Order creatOrder(Integer idUser ,Integer idRoute  , Integer volume , Integer weight , String payment , String date , String type){
        Order order = new Order();
        order.setIdUser(idUser);
        order.setIdRoute(idRoute);
        order.setVolume(volume);
        order.setWeight(weight);
        order.setPayment(payment);
        order.setDate(date);
        order.setType(type);
        return order;
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
