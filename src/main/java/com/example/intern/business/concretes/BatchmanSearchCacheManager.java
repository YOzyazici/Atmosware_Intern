package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanSearchCacheService;
import com.example.intern.dataAccess.abstracts.BatchmanSearchCacheRepository;
import com.example.intern.entities.BatchmanSearchCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchmanSearchCacheManager implements BatchmanSearchCacheService {

    private final BatchmanSearchCacheRepository batchmanSearchCacheRepository;
    @Override
    public List<BatchmanSearchCache> findAllByKeyword(String word) {
        List<BatchmanSearchCache> batchmanSearchCaches = batchmanSearchCacheRepository.findAllByKeyword(word);
        return batchmanSearchCaches;
    }

    @Override
    public BatchmanSearchCache save(BatchmanSearchCache batchmanSearchCache) {
        return batchmanSearchCacheRepository.save(batchmanSearchCache);
    }
}
