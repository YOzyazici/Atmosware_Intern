package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.ExtractFeedSearchCacheService;
import com.example.intern.business.dtos.ExtractFeedSearchCacheDto;
import com.example.intern.dataAccess.abstracts.ExtractFeedSearchCacheRespository;
import com.example.intern.entities.ExtractFeedSearchCache;
import com.example.intern.mapper.ExtractFeedSearchCacheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExtractFeedSearchCacheManager implements ExtractFeedSearchCacheService {

    private final ExtractFeedSearchCacheRespository extractFeedSearchCacheRespository;

    @Override
    public List<ExtractFeedSearchCacheDto> findAllByKeyword(String word) {
        List<ExtractFeedSearchCache> extractFeedSearchCacheList = extractFeedSearchCacheRespository.findAllByKeyword(word);
        List<ExtractFeedSearchCacheDto> extractFeedSearchCacheDtoList = new ArrayList<>();
        for (var extractFeedSearchCache : extractFeedSearchCacheList){
            ExtractFeedSearchCacheDto extractFeedSearchCacheDto = ExtractFeedSearchCacheMapper.INSTANCE.extractFeedSearchCacheToDto(extractFeedSearchCache);
            extractFeedSearchCacheDtoList.add(extractFeedSearchCacheDto);
        }
        return extractFeedSearchCacheDtoList;
    }

    @Override
    public ExtractFeedSearchCacheDto save(ExtractFeedSearchCacheDto extractFeedSearchCacheDto) {
        ExtractFeedSearchCache extractFeedSearchCache = ExtractFeedSearchCacheMapper.INSTANCE.dtoToExtractFeedSearchCache(extractFeedSearchCacheDto);
        extractFeedSearchCacheRespository.save(extractFeedSearchCache);
        return ExtractFeedSearchCacheMapper.INSTANCE.extractFeedSearchCacheToDto(extractFeedSearchCache);
    }
}
