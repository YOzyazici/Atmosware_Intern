package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.ExtractFeedSearchCacheService;
import com.example.intern.business.abstracts.ExtractFeedService;
import com.example.intern.business.abstracts.LlamaAiService;
import com.example.intern.business.dtos.ExtractFeedDto;
import com.example.intern.business.dtos.ExtractFeedSearchCacheDto;
import com.example.intern.core.utils.exceptions.types.BusinessException;
import com.example.intern.dataAccess.abstracts.ExtractFeedRepository;
import com.example.intern.entities.ExtractFeed;
import com.example.intern.entities.ExtractFeedSearchCache;
import com.example.intern.mapper.ExtractFeedMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExtractFeedManager implements ExtractFeedService {
    private final ExtractFeedRepository extractFeedRepository;
    private final LlamaAiService llamaAiService;
    private final ExtractFeedSearchCacheService extractFeedSearchCacheService;
    String ai="Bunu tek cümle de açıkla";

    public List<ExtractFeedDto> getAllExtractFeeds() {
        List<ExtractFeed> extractFeeds = extractFeedRepository.findAll();
        List<ExtractFeedDto> extractFeedDtos = new ArrayList<ExtractFeedDto>();
        for (var extractFeed : extractFeeds){
            ExtractFeedDto extractFeedDto = ExtractFeedMapper.INSTANCE.extractFeedToDTO(extractFeed);
            extractFeedDtos.add(extractFeedDto);
        }
        return extractFeedDtos;
    }

    public Optional<ExtractFeedDto> getExtractFeedById(String feedId) {
        Optional<ExtractFeed> extractFeed = extractFeedRepository.findById(feedId);
        return extractFeed.map(ExtractFeedMapper.INSTANCE::extractFeedToDTO);
    }

    public List<ExtractFeedDto> searchByAllFields(String word) {
        List<ExtractFeed> extractFeeds = extractFeedRepository.searchByAllFields(word);
        List<ExtractFeedDto> extractFeedDtos = new ArrayList<>();
        List<ExtractFeedSearchCacheDto> extractFeedSearchCacheDtoList = extractFeedSearchCacheService.findAllByKeyword(word);

        for (var extractFeed : extractFeeds){
            ExtractFeedDto extractFeedDto = ExtractFeedMapper.INSTANCE.extractFeedToDTO(extractFeed);
            boolean isCached = false;

            for (var extractFeedSearchCacheDto : extractFeedSearchCacheDtoList){
                if (extractFeedSearchCacheDto.getLine().equals(extractFeedDto.getExSql())){
                    extractFeedDto.setExtractFeedJob(extractFeedSearchCacheDto.getResult());
                    isCached = true;
                    break;
                }
            }

            if (!isCached){
                if (!extractFeedDto.getExSql().isEmpty()){
                    extractFeedDto.setExtractFeedJob(llamaAiService.generateMessage(extractFeedDto.getExSql()+ai));
                    ExtractFeedSearchCacheDto extractFeedSearchCacheDto = new ExtractFeedSearchCacheDto();
                    extractFeedSearchCacheDto.setKeyword(word);
                    extractFeedSearchCacheDto.setLine(extractFeedDto.getExSql());
                    extractFeedSearchCacheDto.setResult(extractFeedDto.getExtractFeedJob());
                    extractFeedSearchCacheService.save(extractFeedSearchCacheDto);
                }
                else throw new BusinessException("ExSQl null");
            }

            extractFeedDtos.add(extractFeedDto);
        }
        return extractFeedDtos;
    }

    public ExtractFeedDto createExtractFeed(ExtractFeedDto extractFeedDto) {
        ExtractFeed extractFeed = ExtractFeedMapper.INSTANCE.dtoToExtractFeed(extractFeedDto);
        extractFeedRepository.save(extractFeed);
        return ExtractFeedMapper.INSTANCE.extractFeedToDTO(extractFeed);
    }

    public void deleteExtractFeed(String feedId) {
        extractFeedRepository.deleteById(feedId);
    }
}
