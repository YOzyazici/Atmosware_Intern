package com.example.intern.mapper;

import com.example.intern.business.dtos.DbaSourceSearchCacheDto;
import com.example.intern.entities.DbaSourceSearchCache;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DbaSourceSearchCacheMapper {

    DbaSourceSearchCacheMapper INSTANCE = Mappers.getMapper(DbaSourceSearchCacheMapper.class);

    DbaSourceSearchCacheDto dbaSourceSearchCacheToDto(DbaSourceSearchCache dbaSourceSearchCache);

    DbaSourceSearchCache dtoToDbaSourceSearchCache(DbaSourceSearchCacheDto dbaSourceSearchCacheDto);

}
