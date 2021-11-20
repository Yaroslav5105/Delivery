package com.yaroslav.delivery.service;

import com.yaroslav.delivery.dao.PriceDAO;
import com.yaroslav.delivery.dto.PriceDto;
import com.yaroslav.delivery.model.PriceModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceService {

    PriceDAO priceDAO = new PriceDAO();

    public List<PriceDto>  findPrice (){
        List<PriceDto> priceDtos = new ArrayList<>();
        List<PriceModel> priceModels = priceDAO.findPrice();

        for(PriceModel priceModel : priceModels){
            PriceDto priceDto = new PriceDto();
            priceDtos.add(priceDto);
            priceDto.setKilometer(priceModel.getKilometer());
            priceDto.setVolume(priceModel.getVolume());
            priceDto.setWeight(priceModel.getWeight());
            priceDto.setId(priceModel.getId());
        }
        return priceDtos;
    }
}
