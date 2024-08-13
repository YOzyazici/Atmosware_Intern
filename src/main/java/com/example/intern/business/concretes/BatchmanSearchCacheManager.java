package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanSearchCacheService;
import com.example.intern.business.dtos.BatchmanSearchCacheDto;
import com.example.intern.dataAccess.abstracts.BatchmanSearchCacheRepository;
import com.example.intern.entities.BatchmanSearchCache;
import com.example.intern.mapper.BatchmanSearchCacheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchmanSearchCacheManager implements BatchmanSearchCacheService {

    private final BatchmanSearchCacheRepository batchmanSearchCacheRepository;
    @Override
    public List<BatchmanSearchCacheDto> findAllByKeyword(String word) {
        List<BatchmanSearchCache> batchmanSearchCacheList = batchmanSearchCacheRepository.findAllByKeyword(word);
        List<BatchmanSearchCacheDto> batchmanSearchCacheDtoList = new ArrayList<>();
        for (var batchmanSearchCache: batchmanSearchCacheList){
            BatchmanSearchCacheDto batchmanSearchCacheDto = BatchmanSearchCacheMapper.INSTANCE.batchmanSearchCacheToDto(batchmanSearchCache);
            batchmanSearchCacheDtoList.add(batchmanSearchCacheDto);
        }
        return batchmanSearchCacheDtoList;
    }

    @Override
    public BatchmanSearchCacheDto save(BatchmanSearchCacheDto batchmanSearchCacheDto) {
        BatchmanSearchCache batchmanSearchCache = BatchmanSearchCacheMapper.INSTANCE.dtoToBatchmanSearchCache(batchmanSearchCacheDto);
        batchmanSearchCacheRepository.save(batchmanSearchCache);
        return BatchmanSearchCacheMapper.INSTANCE.batchmanSearchCacheToDto(batchmanSearchCache);
    }
}
