package com.example.intern.business.abstracts;

import com.example.intern.entities.BatchmanSearchCache;

import java.util.List;

public interface BatchmanSearchCacheService {
    List<BatchmanSearchCache> findAllByKeyword(String word);
    BatchmanSearchCache save(BatchmanSearchCache batchmanSearchCache);
}
