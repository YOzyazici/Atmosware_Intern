package com.example.intern.business.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DbaSourceDto {
    private Long line;
    private String owner;
    private String name;
    private String type;
    private String text;
}
