package com.example.intern.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DbaSourceSearchCacheDto {
    private String id;
    private String keyword;
    private String line;
    private String result;
}
