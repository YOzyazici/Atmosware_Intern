package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.dataAccess.abstracts.BatchmanRepository;
import com.example.intern.entities.Batchman;
import com.example.intern.mapper.BatchmanMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchmanManager implements BatchmanService {

    private final BatchmanRepository batchmanRepository;

    public List<BatchmanDto> getAllBatchmen() {
        List<Batchman> batchmans = batchmanRepository.findAll();
        List<BatchmanDto> batchmanDtos = new ArrayList<BatchmanDto>();
        for (var batchman : batchmans) {
            BatchmanDto batchmanDto = BatchmanMapper.INSTANCE.batchmanToDTO(batchman);
            batchmanDtos.add(batchmanDto);
        }
        return batchmanDtos;
    }

    public Optional<BatchmanDto> getBatchmanById(String batchId) {
        Optional<Batchman> batchman = batchmanRepository.findById(batchId);
        return batchman.map(BatchmanMapper.INSTANCE::batchmanToDTO);
    }

    public List<BatchmanDto> searchByAllFields(String word) {
        List<Batchman> batchmans = batchmanRepository.searchByAllFields(word);
        List<BatchmanDto> batchmanDtos = new ArrayList<>();
        for (var batchman : batchmans){
            BatchmanDto batchmanDto = BatchmanMapper.INSTANCE.batchmanToDTO(batchman);
            batchmanDtos.add(batchmanDto);
        }
        return batchmanDtos;
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
