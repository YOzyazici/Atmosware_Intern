package com.example.intern.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchmanDto {
    private String batchId;
    private String batchDesc;
    private String batchName;
    private String batchChapter;
}
