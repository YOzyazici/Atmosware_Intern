package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.ExtractFeedService;
import com.example.intern.dataAccess.abstracts.ExtractFeedRepository;
import com.example.intern.entities.ExtractFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExtractFeedManager implements ExtractFeedService {
    private final ExtractFeedRepository extractFeedRepository;

    public List<ExtractFeed> getAllExtractFeeds() {
        return extractFeedRepository.findAll();
    }

    public Optional<ExtractFeed> getExtractFeedById(String feedId) {
        return extractFeedRepository.findById(feedId);
    }

    public List<ExtractFeed> searchByAllFields(String searchTerm) {
        return extractFeedRepository.searchByAllFields(searchTerm);
    }

    public ExtractFeed createExtractFeed(ExtractFeed extractFeed) {
        return extractFeedRepository.save(extractFeed);
    }

    public void deleteExtractFeed(String feedId) {
        extractFeedRepository.deleteById(feedId);
    }
}
