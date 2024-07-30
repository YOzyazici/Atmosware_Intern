package com.example.intern.business.abstracts;

import com.example.intern.entities.ExtractFeed;

import java.util.List;
import java.util.Optional;

public interface ExtractFeedService {
    List<ExtractFeed> getAllExtractFeeds();
    Optional<ExtractFeed> getExtractFeedById(String feedId);
    List<ExtractFeed> searchByAllFields(String searchTerm);
    ExtractFeed createExtractFeed(ExtractFeed extractFeed);
    void deleteExtractFeed(String feedId);
}
