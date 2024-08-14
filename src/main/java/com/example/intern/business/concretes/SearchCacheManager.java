package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.SearchCacheService;
import com.example.intern.business.dtos.SearchCacheDto;
import com.example.intern.dataAccess.abstracts.SearchCacheRepository;
import com.example.intern.entities.SearchCache;
import com.example.intern.mapper.SearchCacheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchCacheManager implements SearchCacheService {

    private final SearchCacheRepository repository;

    @Override
    public List<SearchCacheDto> findAllByKeyword(String word) {
        List<SearchCache> searchCacheList = repository.findAllByLineContaining(word);
        List<SearchCacheDto> searchCacheDtoList = new ArrayList<>();
        for (var searchCache: searchCacheList){
            SearchCacheDto searchCacheDto = SearchCacheMapper.INSTANCE.searchCacheToDto(searchCache);
            searchCacheDtoList.add(searchCacheDto);
        }
        return searchCacheDtoList;
    }

    @Override
    public SearchCacheDto save(SearchCacheDto searchCacheDto) {
        SearchCache searchCache = SearchCacheMapper.INSTANCE.dtoToSearchCache(searchCacheDto);
        repository.save(searchCache);
        return SearchCacheMapper.INSTANCE.searchCacheToDto(searchCache);
    }
}
