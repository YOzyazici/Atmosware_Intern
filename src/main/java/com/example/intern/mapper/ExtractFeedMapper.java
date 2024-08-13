package com.example.intern.mapper;

import com.example.intern.business.dtos.ExtractFeedDto;
import com.example.intern.entities.ExtractFeed;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.sql.Clob;
import java.sql.SQLException;

@Mapper(componentModel = "spring")
public interface ExtractFeedMapper {

    ExtractFeedMapper INSTANCE = Mappers.getMapper(ExtractFeedMapper.class);

    @Mapping(target = "prevScript", source = "prevScript", qualifiedByName = "clobToString")
    ExtractFeedDto extractFeedToDTO(ExtractFeed extractFeed);

    @Mapping(target = "prevScript", source = "prevScript", qualifiedByName = "stringToClob")
    ExtractFeed dtoToExtractFeed(ExtractFeedDto extractFeedDto);

    @Named("clobToString")
    default String clobToString(Clob clob) {
        if (clob == null) {
            return null;
        }
        try {
            return clob.getSubString(1, (int) clob.length());
        } catch (SQLException e) {
            throw new RuntimeException("Error converting Clob to String", e);
        }
    }

    @Named("stringToClob")
    default Clob stringToClob(String content) {
        // Implement this method if you need to convert String back to Clob
        // This usually requires a more complex setup and might not be straightforward
        throw new UnsupportedOperationException("Conversion from String to Clob not implemented");
    }
}

