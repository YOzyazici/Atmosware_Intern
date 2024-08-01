package com.example.intern.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Clob;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParamsDto {
    private String id;
    private String name;
    private Clob sqlQuery;
}
