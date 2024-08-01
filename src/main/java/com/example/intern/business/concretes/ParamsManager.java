package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.ParamsService;
import com.example.intern.business.dtos.ParamsDto;
import com.example.intern.dataAccess.abstracts.ParamsRepository;
import com.example.intern.entities.Params;
import com.example.intern.mapper.ParamsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParamsManager implements ParamsService {

    private final ParamsRepository paramsRepository;

    public ParamsDto saveParams(ParamsDto paramsDto) {
        Params params = ParamsMapper.INSTANCE.DtoToParams(paramsDto);
        paramsRepository.save(params);
        return ParamsMapper.INSTANCE.paramsToDto(params);
    }
}
