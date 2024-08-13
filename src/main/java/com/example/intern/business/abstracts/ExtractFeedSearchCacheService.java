package com.example.intern.business.abstracts;

import com.example.intern.entities.ExtractFeedSearchCache;

import java.util.List;

public interface ExtractFeedSearchCacheService {
    List<ExtractFeedSearchCache> findAllByKeyword(String word);
    ExtractFeedSearchCache save(ExtractFeedSearchCache extractFeedSearchCache);
}
