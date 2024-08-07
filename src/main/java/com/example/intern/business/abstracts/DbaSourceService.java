package com.example.intern.business.abstracts;

import com.example.intern.entities.DbaSource;

import java.util.List;

public interface DbaSourceService {
    List<DbaSource> searchByAllDb(String keyword);
}
