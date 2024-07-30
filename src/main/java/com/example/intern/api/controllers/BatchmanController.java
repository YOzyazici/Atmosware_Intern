package com.example.intern.api.controllers;

import com.example.intern.business.abstracts.BatchmanService;
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
    public List<Batchman> getAllBatchmen() {
        return batchmanService.getAllBatchmen();
    }

    @GetMapping("/{batchId}")
    public ResponseEntity<Batchman> getBatchmanById(@PathVariable String batchId) {
        return batchmanService.getBatchmanById(batchId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Batchman> getBatchmenByName(@RequestParam String name) {
        return batchmanService.searchByAllFields(name);
    }

    @PostMapping
    public Batchman createBatchman(@RequestBody Batchman batchman) {
        return batchmanService.createBatchman(batchman);
    }

    @DeleteMapping("/{batchId}")
    public ResponseEntity<Void> deleteBatchman(@PathVariable String batchId) {
        batchmanService.deleteBatchman(batchId);
        return ResponseEntity.noContent().build();
    }
}
