package com.yaroslav.delivery.converter;

import com.yaroslav.delivery.dto.LuggageDto;
import com.yaroslav.delivery.model.LuggageModel;

public class LuggageConverter implements Converter<LuggageModel, LuggageDto> {

    @Override
    public LuggageDto convert(LuggageModel source) {
        LuggageDto luggageDto = new LuggageDto();
        luggageDto.setId(source.getId());
        luggageDto.setType(source.getType());
        return luggageDto;
    }
}