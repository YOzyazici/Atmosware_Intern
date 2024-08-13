package com.example.intern.business.abstracts;

import com.example.intern.business.dtos.DbaSourceSearchCacheDto;
import com.example.intern.entities.DbaSourceSearchCache;

import java.util.List;

public interface DbaSourceSearchCacheService {
    List<DbaSourceSearchCacheDto> findAllByKeyword(String word);
    DbaSourceSearchCacheDto save(DbaSourceSearchCacheDto dbaSourceSearchCacheDto);
}
