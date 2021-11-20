package com.yaroslav.delivery.converter;

public interface Converter<S, T> {

    T convert(S source);
}
