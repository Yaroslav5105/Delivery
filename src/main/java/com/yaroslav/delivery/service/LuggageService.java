package com.yaroslav.delivery.service;

import com.yaroslav.delivery.converter.LuggageConverter;
import com.yaroslav.delivery.dao.LuggageDao;
import com.yaroslav.delivery.dto.LuggageDto;
import com.yaroslav.delivery.model.LuggageModel;

import java.util.List;

public class LuggageService {
    private  LuggageDao luggageDao = new LuggageDao();
    private LuggageConverter luggageConverter = new LuggageConverter();

    public List<LuggageDto> findAllLuggages() {
        List<LuggageModel> luggageModels = luggageDao.selectLuggage();
        return luggageConverter.convertList(luggageModels);

    }
}
