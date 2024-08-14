package com.example.intern.mapper;

import com.example.intern.business.dtos.SearchCacheDto;
import com.example.intern.entities.SearchCache;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SearchCacheMapper {

    SearchCacheMapper INSTANCE = Mappers.getMapper(SearchCacheMapper.class);

    SearchCacheDto searchCacheToDto(SearchCache searchCache);

    SearchCache dtoToSearchCache(SearchCacheDto searchCacheDto);
}
