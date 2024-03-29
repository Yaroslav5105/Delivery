package com.yaroslav.delivery.model;

public class PriceModel {

    private Integer id;
    private Integer kilometer;
    private Integer volume;
    private Integer weight;

    public PriceModel() {
    }

    public PriceModel(Integer id, Integer kilometer, Integer volume, Integer weight) {
        this.id = id;
        this.kilometer = kilometer;
        this.volume = volume;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public void setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
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
}
