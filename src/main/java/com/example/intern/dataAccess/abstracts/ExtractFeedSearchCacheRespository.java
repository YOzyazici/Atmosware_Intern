package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.ExtractFeedSearchCache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtractFeedSearchCacheRespository extends JpaRepository<ExtractFeedSearchCache, String> {
    List<ExtractFeedSearchCache> findAllByKeyword(String keyword);
}
