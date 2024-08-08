package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.ExtractFeedService;
import com.example.intern.business.abstracts.LlamaAiService;
import com.example.intern.business.dtos.ExtractFeedDto;
import com.example.intern.core.utils.exceptions.types.BusinessException;
import com.example.intern.dataAccess.abstracts.ExtractFeedRepository;
import com.example.intern.entities.ExtractFeed;
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
        for (var extractFeed : extractFeeds){
            ExtractFeedDto extractFeedDto = ExtractFeedMapper.INSTANCE.extractFeedToDTO(extractFeed);
            extractFeedDtos.add(extractFeedDto);
            if (!extractFeedDto.getExSql().isEmpty()) extractFeedDto.setExtractFeedJob(llamaAiService.generateMessage(extractFeedDto.getExSql()+"Bunu tek cümle de açıkla"));
            else new BusinessException("ExSQl null");
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
