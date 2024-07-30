package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.ParamsService;
import com.example.intern.dataAccess.abstracts.ParamsRepository;
import com.example.intern.entities.Params;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParamsManager implements ParamsService {

    private final ParamsRepository paramsRepository;

    public Params saveParams(Params params) {
        return paramsRepository.save(params);
    }
}
