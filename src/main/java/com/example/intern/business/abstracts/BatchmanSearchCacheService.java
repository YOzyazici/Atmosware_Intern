package com.example.intern.business.abstracts;

import com.example.intern.business.dtos.BatchmanSearchCacheDto;
import com.example.intern.entities.BatchmanSearchCache;

import java.util.List;

public interface BatchmanSearchCacheService {
    List<BatchmanSearchCacheDto> findAllByKeyword(String word);
    BatchmanSearchCacheDto save(BatchmanSearchCacheDto batchmanSearchCacheDto);
}
