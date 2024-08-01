package com.example.intern.mapper;

import com.example.intern.business.dtos.ParamsDto;
import com.example.intern.entities.Params;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParamsMapper {

    ParamsMapper INSTANCE = Mappers.getMapper(ParamsMapper.class);

    ParamsDto paramsToDto(Params params);
    Params DtoToParams(ParamsDto paramsDto);
}
