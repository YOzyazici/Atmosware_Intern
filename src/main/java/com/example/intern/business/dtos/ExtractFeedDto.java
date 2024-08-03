package com.example.intern.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Clob;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExtractFeedDto {
    private String feedId;
    private String feedDesc;
    private String feedFileName;
    private String exSql;
    private String postScript;
    private String prevScript;
}
