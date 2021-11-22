package com.yaroslav.delivery.converter;

import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserConverter implements Converter<UserModel , UserDto> , ConverterList <UserModel , UserDto> {

    @Override
    public UserDto convert(UserModel source) {
        UserDto userDto = new UserDto();
        userDto.setId(source.getId());
        userDto.setLogin(source.getLogin());
        userDto.setPassword(source.getPassword());
        userDto.setNumber(source.getNumber());
        userDto.setEmail(source.getMail());

        return userDto;
    }

    @Override
    public List<UserDto> convertList(List<UserModel> source) {
        List<UserDto> userDtos = new ArrayList<>();

        for (UserModel userModel : source) {
            UserDto userDto = new UserDto();
            userDtos.add(userDto);
            userDto.setId(userModel.getId());
            userDto.setLogin(userModel.getLogin());
            userDto.setPassword(userModel.getPassword());
            userDto.setNumber(userModel.getNumber());
            userDto.setEmail(userModel.getMail());
        }
        return userDtos;
    }
}
