package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.dataAccess.abstracts.BatchmanRepository;
import com.example.intern.entities.Batchman;
import com.example.intern.mapper.BatchmanMapper;
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

    public BatchmanDto createBatchman(BatchmanDto batchmanDto) {
        Batchman batchman = BatchmanMapper.INSTANCE.DtoToBatchman(batchmanDto);
        batchmanRepository.save(batchman);
        return BatchmanMapper.INSTANCE.batchmanToDTO(batchman);
    }

    public void deleteBatchman(String batchId) {
        batchmanRepository.deleteById(batchId);
    }
}
