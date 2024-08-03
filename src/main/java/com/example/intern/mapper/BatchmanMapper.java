package com.example.intern.mapper;

import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.entities.Batchman;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Clob;
import java.sql.SQLException;

@Mapper(componentModel = "spring")
public interface BatchmanMapper {

    BatchmanMapper INSTANCE = Mappers.getMapper(BatchmanMapper.class);

    @Mapping(target = "scriptClob", source = "scriptClob", qualifiedByName = "clobToString")
    BatchmanDto batchmanToDTO(Batchman batchman);

    @Mapping(target = "scriptClob", source = "scriptClob", qualifiedByName = "stringToClob")
    Batchman dtoToBatchman(BatchmanDto batchmanDto);

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

