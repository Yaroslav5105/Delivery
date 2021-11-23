package com.yaroslav.delivery.dto;

public class RouteDto {

    private Integer id;
    private String way;
    private Integer kilometers;

    public RouteDto() {
    }

    public RouteDto(Integer id, String way, Integer kilometers) {
        this.id = id;
        this.way = way;
        this.kilometers = kilometers;
    }

    public RouteDto(String way, Integer kilometers) {
        this.way = way;
        this.kilometers = kilometers;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
