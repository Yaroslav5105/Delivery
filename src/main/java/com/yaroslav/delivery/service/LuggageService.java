package com.yaroslav.delivery.service;

import com.yaroslav.delivery.converter.Converter;
import com.yaroslav.delivery.converter.LuggageConverter;
import com.yaroslav.delivery.dao.LuggageDao;
import com.yaroslav.delivery.dto.LuggageDto;
import com.yaroslav.delivery.model.LuggageModel;

import java.util.ArrayList;
import java.util.List;

public class LuggageService {
    private final LuggageDao luggageDao = new LuggageDao();
    private final Converter<LuggageModel, LuggageDto> luggageConverter = new LuggageConverter();

    public List<LuggageDto> findAllLuggages() {

        List<LuggageDto> luggageDtos = new ArrayList<>();
        List<LuggageModel> luggageModels = luggageDao.selectLuggage();
        for (LuggageModel luggageModel : luggageModels) {
            luggageDtos.add(luggageConverter.convert(luggageModel));
        }
        return luggageDtos;
    }
}
