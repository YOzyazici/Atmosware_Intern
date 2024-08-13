package com.example.intern.mapper;

import com.example.intern.business.dtos.BatchmanSearchCacheDto;
import com.example.intern.entities.BatchmanSearchCache;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BatchmanSearchCacheMapper {

    BatchmanSearchCacheMapper INSTANCE = Mappers.getMapper(BatchmanSearchCacheMapper.class);

    BatchmanSearchCacheDto batchmanSearchCacheToDto(BatchmanSearchCache batchmanSearchCache);

    BatchmanSearchCache dtoToBatchmanSearchCache(BatchmanSearchCacheDto batchmanSearchCacheDto);

}
