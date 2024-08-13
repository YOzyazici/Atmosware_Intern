package com.example.intern.business.abstracts;

import com.example.intern.entities.DbaSourceSearchCache;

import java.util.List;

public interface DbaSourceSearchCacheService {
    List<DbaSourceSearchCache> findAllByKeyword(String word);
    DbaSourceSearchCache save(DbaSourceSearchCache dbaSourceSearchCache);
}
