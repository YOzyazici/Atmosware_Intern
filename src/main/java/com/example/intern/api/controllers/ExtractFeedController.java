package com.example.intern.api.controllers;

import com.example.intern.business.abstracts.ExtractFeedService;
import com.example.intern.entities.ExtractFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/extract_feed")
public class ExtractFeedController {

    private final ExtractFeedService extractFeedService;

    @GetMapping
    public List<ExtractFeed> getAllExtractFeeds() {
        return extractFeedService.getAllExtractFeeds();
    }

    @GetMapping("/{feedId}")
    public ResponseEntity<ExtractFeed> getExtractFeedById(@PathVariable String feedId) {
        return extractFeedService.getExtractFeedById(feedId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<ExtractFeed> searchByAllFields(@RequestParam String term) {
        return extractFeedService.searchByAllFields(term);
    }

    @PostMapping
    public ExtractFeed createExtractFeed(@RequestBody ExtractFeed extractFeed) {
        return extractFeedService.createExtractFeed(extractFeed);
    }

    @DeleteMapping("/{feedId}")
    public ResponseEntity<Void> deleteExtractFeed(@PathVariable String feedId) {
        extractFeedService.deleteExtractFeed(feedId);
        return ResponseEntity.noContent().build();
    }
}
