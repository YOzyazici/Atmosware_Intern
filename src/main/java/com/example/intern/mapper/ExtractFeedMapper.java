package com.example.intern.mapper;

import com.example.intern.business.dtos.ExtractFeedDto;
import com.example.intern.entities.ExtractFeed;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExtractFeedMapper {

    ExtractFeedMapper INSTANCE = Mappers.getMapper(ExtractFeedMapper.class);

    ExtractFeedDto extractFeedToDTO(ExtractFeed extractFeed);
    ExtractFeed DtoToExtractFeed(ExtractFeedDto extractFeedDto);
}
