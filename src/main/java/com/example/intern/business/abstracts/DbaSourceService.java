package com.example.intern.business.abstracts;

import com.example.intern.business.dtos.DbaSourceDto;
import com.example.intern.entities.DbaSource;

import java.util.List;

public interface DbaSourceService {
    List<DbaSourceDto> searchByAllDb(String keyword);
}
