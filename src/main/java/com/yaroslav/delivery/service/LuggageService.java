package com.yaroslav.delivery.service;

import com.yaroslav.delivery.converter.Converter;
import com.yaroslav.delivery.converter.LuggageConverter;
import com.yaroslav.delivery.dao.LuggageDAO;
import com.yaroslav.delivery.dto.LuggageDto;
import com.yaroslav.delivery.model.LuggageModel;

import java.util.ArrayList;
import java.util.List;

public class LuggageService {
    LuggageDAO luggageDAO = new LuggageDAO();
    private Converter<LuggageModel, LuggageDto> luggageConverter = new LuggageConverter();

    public List<LuggageDto> findAllLuggage() {

        List<LuggageDto> luggageDtos = new ArrayList<>();

        List<LuggageModel> luggageModels = luggageDAO.findAllLuggage();
        for (LuggageModel luggageModel : luggageModels) {
            luggageDtos.add(luggageConverter.convert(luggageModel));
        }
        return luggageDtos;
    }
}
