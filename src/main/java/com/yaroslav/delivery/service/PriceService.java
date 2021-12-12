package com.yaroslav.delivery.service;

import com.yaroslav.delivery.converter.PriceConverter;
import com.yaroslav.delivery.dao.PriceDao;
import com.yaroslav.delivery.dto.PriceDto;

import java.util.List;

public class PriceService {

    private  PriceDao priceDao = new PriceDao();
    private  PriceConverter priceConverter = new PriceConverter();

    public List<PriceDto> findPrices() {
        return priceConverter.convertList(priceDao.selectPrices());
    }
}
