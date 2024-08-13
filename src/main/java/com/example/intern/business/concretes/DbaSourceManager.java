package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.DbaSourceSearchCacheService;
import com.example.intern.business.abstracts.DbaSourceService;
import com.example.intern.business.abstracts.LlamaAiService;
import com.example.intern.business.dtos.DbaSourceDto;
import com.example.intern.core.utils.exceptions.types.BusinessException;
import com.example.intern.dataAccess.abstracts.DbaSourceRepository;
import com.example.intern.entities.DbaSource;
import com.example.intern.entities.DbaSourceSearchCache;
import com.example.intern.mapper.DbaSourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DbaSourceManager implements DbaSourceService {

    private final DbaSourceRepository dbaSourceRepository;
    private final LlamaAiService llamaAiService;
    private final DbaSourceSearchCacheService dbaSourceSearchCacheService;
    String ai="Bunu tek cümle de açıkla";

    @Override
    public List<DbaSourceDto> searchByAllDb(String word) {

        List<DbaSource> dbaSourceList = dbaSourceRepository.searchByAllDb(word);
        List<DbaSourceDto> dbaSourceDtoList = new ArrayList<>();
        List<DbaSourceSearchCache> dbaSourceSearchCacheList = dbaSourceSearchCacheService.findAllByKeyword(word);

        for (var dbSource : dbaSourceList){
            DbaSourceDto dbaSourceDto = DbaSourceMapper.INSTANCE.dbaSourceToDto(dbSource);
            boolean isCached = false;

            for (var dbaSourceSearchCache : dbaSourceSearchCacheList){
                if (dbaSourceSearchCache.getLine().equals(dbSource.getText())){
                    dbaSourceDto.setDbaSourceJob(dbaSourceSearchCache.getResult());
                    isCached = true;
                    break;
                }
            }

            if (!isCached){
                if (!dbaSourceDto.getText().isEmpty()){
                    dbaSourceDto.setDbaSourceJob(llamaAiService.generateMessage(dbaSourceDto.getText()+ai));
                    DbaSourceSearchCache dbaSourceSearchCache1 = new DbaSourceSearchCache();
                    dbaSourceSearchCache1.setKeyword(word);
                    dbaSourceSearchCache1.setLine(dbaSourceDto.getText());
                    dbaSourceSearchCache1.setResult(dbaSourceDto.getDbaSourceJob());
                    dbaSourceSearchCacheService.save(dbaSourceSearchCache1);
                }
                else throw new BusinessException("Text null");
            }

            dbaSourceDtoList.add(dbaSourceDto);
        }
        return dbaSourceDtoList;
    }
}
