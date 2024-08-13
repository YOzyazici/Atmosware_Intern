package com.example.intern.business.abstracts;

import com.example.intern.business.dtos.ExtractFeedSearchCacheDto;
import com.example.intern.entities.ExtractFeedSearchCache;

import java.util.List;

public interface ExtractFeedSearchCacheService {
    List<ExtractFeedSearchCacheDto> findAllByKeyword(String word);
    ExtractFeedSearchCacheDto save(ExtractFeedSearchCacheDto extractFeedSearchCacheDto);
}
