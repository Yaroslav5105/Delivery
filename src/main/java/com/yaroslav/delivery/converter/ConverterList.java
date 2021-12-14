package com.yaroslav.delivery.converter;

import java.util.List;

public interface ConverterList<S, T> {

    List<T> convertList(List<S> source);
}