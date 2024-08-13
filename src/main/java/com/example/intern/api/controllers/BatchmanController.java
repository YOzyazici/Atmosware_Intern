package com.example.intern.api.controllers;

import com.example.intern.business.abstracts.BatchmanSearchCacheService;
import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.dataAccess.abstracts.BatchmanSearchCacheRepository;
import com.example.intern.entities.Batchman;
import com.example.intern.entities.BatchmanSearchCache;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/batchmen")
public class BatchmanController {

    private final BatchmanService batchmanService;
    private final BatchmanSearchCacheService batchmanSearchCacheService;

    @GetMapping
    public List<BatchmanDto> getAllBatchmen() {
        return batchmanService.getAllBatchmen();
    }

    @GetMapping("/{batchId}")
    public ResponseEntity<BatchmanDto> getBatchmanById(@PathVariable String batchId) {
        return batchmanService.getBatchmanById(batchId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<BatchmanDto> searchByAllFields(@RequestParam String word) {
        return batchmanService.searchByAllFields(word);
    }

    @PostMapping
    public BatchmanDto createBatchman(@RequestBody BatchmanDto batchmanDto) {
        return batchmanService.createBatchman(batchmanDto);
    }

    @DeleteMapping("/{batchId}")
    public ResponseEntity<Void> deleteBatchman(@PathVariable String batchId) {
        batchmanService.deleteBatchman(batchId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/all/{keyword}")
    public ResponseEntity<?> findAllByKeyword(@PathVariable String keyword) {
        List<BatchmanSearchCache> cacheResults = batchmanSearchCacheService.findAllByKeyword(keyword);

        if (!cacheResults.isEmpty()) {
            return ResponseEntity.ok(cacheResults);
        } else {
            return ResponseEntity.status(404).body("No results found for keyword: " + keyword);
        }
    }
}
