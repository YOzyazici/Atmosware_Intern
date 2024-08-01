package com.example.intern.business.abstracts;

import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.entities.Batchman;

import java.util.List;
import java.util.Optional;

public interface BatchmanService {
    List<Batchman> getAllBatchmen();
    Optional<Batchman> getBatchmanById(String batchId);
    List<Batchman> searchByAllFields(String batchName);
    BatchmanDto createBatchman(BatchmanDto batchmanDto);
    void deleteBatchman(String batchId);
}
