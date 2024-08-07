package com.example.intern.mapper;

import com.example.intern.business.dtos.DbaSourceDto;
import com.example.intern.entities.DbaSource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DbaSourceMapper {

    DbaSourceMapper INSTANCE = Mappers.getMapper(DbaSourceMapper.class);

    DbaSourceDto dbaSourceToDto(DbaSource dbaSource);

    DbaSource dtoToDbaSource(DbaSourceDto dbaSourceDto);
}
