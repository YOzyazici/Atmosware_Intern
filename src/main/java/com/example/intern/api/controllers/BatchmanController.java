package com.example.intern.api.controllers;

import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.entities.Batchman;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/batchmen")
public class BatchmanController {

    private final BatchmanService batchmanService;

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
    public List<BatchmanDto> searchByAllFields(@RequestParam String term) {
        return batchmanService.searchByAllFields(term);
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
}
