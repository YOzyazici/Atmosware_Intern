package com.example.intern.business.abstracts;

import com.example.intern.business.dtos.SearchCacheDto;

import java.util.List;

public interface SearchCacheService {
    List<SearchCacheDto> findAllByKeyword(String word);
    SearchCacheDto save(SearchCacheDto searchCacheDto);
}