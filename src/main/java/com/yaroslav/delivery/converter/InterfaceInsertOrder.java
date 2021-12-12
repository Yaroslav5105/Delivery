package com.yaroslav.delivery.converter;

import com.yaroslav.delivery.model.OrderModel;

public interface InterfaceInsertOrder {
    OrderModel create(int a , int b , int c, int d , String e , String f , String g);
}
