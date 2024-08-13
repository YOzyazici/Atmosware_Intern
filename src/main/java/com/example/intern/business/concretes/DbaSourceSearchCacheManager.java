package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.DbaSourceSearchCacheService;
import com.example.intern.business.dtos.DbaSourceSearchCacheDto;
import com.example.intern.dataAccess.abstracts.DbaSourceSearchCacheRepository;
import com.example.intern.entities.DbaSourceSearchCache;
import com.example.intern.mapper.DbaSourceSearchCacheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbaSourceSearchCacheManager implements DbaSourceSearchCacheService {

    private final DbaSourceSearchCacheRepository dbaSourceSearchCacheRepository;

    @Override
    public List<DbaSourceSearchCacheDto> findAllByKeyword(String word) {
        List<DbaSourceSearchCache> dbaSourceSearchCacheList = dbaSourceSearchCacheRepository.findAllByKeyword(word);
        List<DbaSourceSearchCacheDto> dbaSourceSearchCacheDtoList = new ArrayList<>();
        for (var dbaSourceSearchCache : dbaSourceSearchCacheList){
            DbaSourceSearchCacheDto dbaSourceSearchCacheDto=DbaSourceSearchCacheMapper.INSTANCE.dbaSourceSearchCacheToDto(dbaSourceSearchCache);
            dbaSourceSearchCacheDtoList.add(dbaSourceSearchCacheDto);
        }

        return dbaSourceSearchCacheDtoList;
    }

    @Override
    public DbaSourceSearchCacheDto save(DbaSourceSearchCacheDto dbaSourceSearchCacheDto) {
        DbaSourceSearchCache dbaSourceSearchCache = DbaSourceSearchCacheMapper.INSTANCE.dtoToDbaSourceSearchCache(dbaSourceSearchCacheDto);
        dbaSourceSearchCacheRepository.save(dbaSourceSearchCache);
        return DbaSourceSearchCacheMapper.INSTANCE.dbaSourceSearchCacheToDto(dbaSourceSearchCache);
    }
}
