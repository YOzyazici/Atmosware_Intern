package com.example.intern.mapper;

import com.example.intern.business.dtos.ExtractFeedSearchCacheDto;
import com.example.intern.entities.ExtractFeedSearchCache;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExtractFeedSearchCacheMapper {

    ExtractFeedSearchCacheMapper INSTANCE = Mappers.getMapper(ExtractFeedSearchCacheMapper.class);

    ExtractFeedSearchCacheDto extractFeedSearchCacheToDto(ExtractFeedSearchCache extractFeedSearchCache);

    ExtractFeedSearchCache dtoToExtractFeedSearchCache(ExtractFeedSearchCacheDto extractFeedSearchCacheDto);

}
