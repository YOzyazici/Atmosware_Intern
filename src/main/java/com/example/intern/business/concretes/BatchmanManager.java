package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.dataAccess.abstracts.BatchmanRepository;
import com.example.intern.entities.Batchman;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchmanManager implements BatchmanService {

    private final BatchmanRepository batchmanRepository;


    public List<Batchman> getAllBatchmen() {
        return batchmanRepository.findAll();
    }

    public Optional<Batchman> getBatchmanById(String batchId) {
        return batchmanRepository.findById(batchId);
    }

    public List<Batchman> searchByAllFields(String batchName) {
        return batchmanRepository.searchByAllFields(batchName);
    }

    public Batchman createBatchman(Batchman batchman) {
        return batchmanRepository.save(batchman);
    }

    public void deleteBatchman(String batchId) {
        batchmanRepository.deleteById(batchId);
    }
}
