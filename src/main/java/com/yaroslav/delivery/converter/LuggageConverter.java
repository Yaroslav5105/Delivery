package com.yaroslav.delivery.converter;

import com.yaroslav.delivery.dto.LuggageDto;
import com.yaroslav.delivery.model.LuggageModel;

import java.util.ArrayList;
import java.util.List;

public class LuggageConverter implements ConverterList<LuggageModel, LuggageDto> {

    @Override
    public List<LuggageDto> convertList(List<LuggageModel> source) {
        List<LuggageDto> luggageDtos = new ArrayList<>();
        for (LuggageModel luggageModel : source) {
            LuggageDto luggageDto = new LuggageDto();
            luggageDtos.add(luggageDto);
            luggageDto.setId(luggageModel.getId());
            luggageDto.setType(luggageModel.getType());
        }
        return luggageDtos;
    }
}
