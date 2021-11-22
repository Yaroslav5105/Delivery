package com.yaroslav.delivery.converter;

import com.yaroslav.delivery.dto.PriceDto;
import com.yaroslav.delivery.model.PriceModel;

import java.util.ArrayList;
import java.util.List;

public class PriceConverter implements ConverterList<PriceModel, PriceDto> {

    @Override
    public List<PriceDto> convertList(List<PriceModel> source) {
        List<PriceDto> priceDtos = new ArrayList<>();
        for (PriceModel priceModel : source) {
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
