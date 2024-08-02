package com.example.intern.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Clob;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchmanDto {
    private String batchId;
    private String batchDesc;
    private String script;
//    private Clob scriptClob;
}
