package com.example.intern.business.abstracts;

import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.entities.Batchman;

import java.util.List;
import java.util.Optional;

public interface BatchmanService {
    List<BatchmanDto> getAllBatchmen();
    Optional<BatchmanDto> getBatchmanById(String batchId);
    List<BatchmanDto> searchByAllFields(String searchTerm);
    BatchmanDto createBatchman(BatchmanDto batchmanDto);
    void deleteBatchman(String batchId);
}
