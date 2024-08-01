package com.example.intern.business.abstracts;

import com.example.intern.business.dtos.ExtractFeedDto;
import com.example.intern.entities.ExtractFeed;

import java.util.List;
import java.util.Optional;

public interface ExtractFeedService {
    List<ExtractFeedDto> getAllExtractFeeds();
    Optional<ExtractFeedDto> getExtractFeedById(String feedId);
    List<ExtractFeedDto> searchByAllFields(String searchTerm);
    ExtractFeedDto createExtractFeed(ExtractFeedDto extractFeedDto);
    void deleteExtractFeed(String feedId);
}
