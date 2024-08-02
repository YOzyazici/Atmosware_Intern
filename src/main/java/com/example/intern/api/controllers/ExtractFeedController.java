package com.example.intern.api.controllers;

import com.example.intern.business.abstracts.ExtractFeedService;
import com.example.intern.business.dtos.ExtractFeedDto;
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
    public List<ExtractFeedDto> getAllExtractFeeds() {
        return extractFeedService.getAllExtractFeeds();
    }

    @GetMapping("/{feedId}")
    public ResponseEntity<ExtractFeedDto> getExtractFeedById(@PathVariable String feedId) {
        return extractFeedService.getExtractFeedById(feedId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<ExtractFeedDto> searchByAllFields(@RequestParam String word) {
        return extractFeedService.searchByAllFields(word);
    }

    @PostMapping
    public ExtractFeedDto createExtractFeed(@RequestBody ExtractFeedDto extractFeedDto) {
        return extractFeedService.createExtractFeed(extractFeedDto);
    }

    @DeleteMapping("/{feedId}")
    public ResponseEntity<Void> deleteExtractFeed(@PathVariable String feedId) {
        extractFeedService.deleteExtractFeed(feedId);
        return ResponseEntity.noContent().build();
    }
}
