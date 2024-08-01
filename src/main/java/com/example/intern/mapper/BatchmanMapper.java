package com.example.intern.mapper;

import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.entities.Batchman;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BatchmanMapper {

    BatchmanMapper INSTANCE = Mappers.getMapper(BatchmanMapper.class);

    BatchmanDto batchmanToDTO(Batchman batchman);
    Batchman DtoToBatchman(BatchmanDto batchmanDto);
}
