package com.example.intern.business.abstracts;

import com.example.intern.entities.Batchman;

import java.util.List;
import java.util.Optional;

public interface BatchmanService {
    List<Batchman> getAllBatchmen();
    Optional<Batchman> getBatchmanById(String batchId);
    List<Batchman> searchByAllFields(String batchName);
    Batchman createBatchman(Batchman batchman);
    void deleteBatchman(String batchId);
}
