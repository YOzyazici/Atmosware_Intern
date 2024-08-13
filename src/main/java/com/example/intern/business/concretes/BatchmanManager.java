package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanSearchCacheService;
import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.business.abstracts.LlamaAiService;
import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.core.utils.exceptions.types.BusinessException;
import com.example.intern.dataAccess.abstracts.BatchmanRepository;
import com.example.intern.dataAccess.abstracts.BatchmanSearchCacheRepository;
import com.example.intern.entities.Batchman;
import com.example.intern.entities.BatchmanSearchCache;
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
    private final LlamaAiService llamaAiService;
    private final BatchmanSearchCacheService batchmanSearchCacheService;
    String ai="Bunu tek cümle de açıkla";

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
        List<BatchmanSearchCache> batchmanSearchCaches = batchmanSearchCacheService.findAllByKeyword(word);

        for (var batchman : batchmans) {
            BatchmanDto batchmanDto = BatchmanMapper.INSTANCE.batchmanToDTO(batchman);
            boolean isCached = false;

            for (var batchmanSearchCache : batchmanSearchCaches) {
                if (batchmanSearchCache.getLine().equals(batchmanDto.getScript()) || batchmanSearchCache.getLine().equals(batchmanDto.getScriptClob())) {
                    batchmanDto.setBatchJob(batchmanSearchCache.getResult());
                    isCached = true;
                    break;
                }
            }

            if (!isCached) {
                if (!batchmanDto.getScript().isEmpty()) {
                    batchmanDto.setBatchJob(llamaAiService.generateMessage(batchmanDto.getScript() + ai));
                    BatchmanSearchCache batchmanSearchCache1 = new BatchmanSearchCache();
                    batchmanSearchCache1.setKeyword(word);
                    batchmanSearchCache1.setLine(batchmanDto.getScript());
                    batchmanSearchCache1.setResult(batchmanDto.getBatchJob());
                    batchmanSearchCacheService.save(batchmanSearchCache1);
                } else if (!batchmanDto.getScriptClob().isEmpty()) {
                    batchmanDto.setBatchJob(llamaAiService.generateMessage(batchmanDto.getScriptClob() + ai));
                    BatchmanSearchCache batchmanSearchCache1 = new BatchmanSearchCache();
                    batchmanSearchCache1.setKeyword(word);
                    batchmanSearchCache1.setLine(batchmanDto.getScriptClob());
                    batchmanSearchCache1.setResult(batchmanDto.getBatchJob());
                    batchmanSearchCacheService.save(batchmanSearchCache1);
                } else throw new BusinessException("Script and ScriptClob are both null");
            }

            batchmanDtos.add(batchmanDto);
        }

        return batchmanDtos;
    }

    public BatchmanDto createBatchman(BatchmanDto batchmanDto) {
        Batchman batchman = BatchmanMapper.INSTANCE.dtoToBatchman(batchmanDto);
        batchmanRepository.save(batchman);
        return BatchmanMapper.INSTANCE.batchmanToDTO(batchman);
    }

    public void deleteBatchman(String batchId) {
        batchmanRepository.deleteById(batchId);
    }
}
