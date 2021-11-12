package com.yaroslav.delivery.db.entity;

public class Order {
    private Integer id;
    private String idUser;
    private Integer idRoute;
    private Integer volume;
    private Integer weight;
    private Integer price ;



    public static Order creatOrder(String idUser ,Integer idRoute  , Integer volume , Integer weight ){
        Order order = new Order();
        order.setIdUser(idUser);
        order.setIdRoute(idRoute);
        order.setVolume(volume);
        order.setWeight(weight);

        return order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

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
}
