package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.DbaSourceService;
import com.example.intern.business.dtos.DbaSourceDto;
import com.example.intern.dataAccess.abstracts.DbaSourceRepository;
import com.example.intern.entities.DbaSource;
import com.example.intern.mapper.DbaSourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DbaSourceManager implements DbaSourceService {

    private final DbaSourceRepository dbaSourceRepository;

    @Override
    public List<DbaSourceDto> searchByAllDb(String word) {
        List<DbaSource> dbaSourceList = dbaSourceRepository.searchByAllDb(word);
        List<DbaSourceDto> dbaSourceDtoList = new ArrayList<>();
        for (var dbSource : dbaSourceList){
            DbaSourceDto dbaSourceDto = DbaSourceMapper.INSTANCE.dbaSourceToDto(dbSource);
            dbaSourceDtoList.add(dbaSourceDto);
        }
        return dbaSourceDtoList;
    }
}
