package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.DbaSourceService;
import com.example.intern.dataAccess.abstracts.DbaSourceRepository;
import com.example.intern.entities.DbaSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DbaSourceManager implements DbaSourceService {

    private final DbaSourceRepository dbaSourceRepository;

    @Override
    public List<DbaSource> searchByKeyword(String keyword) {
        return dbaSourceRepository.findByKeyword("%" + keyword + "%");
    }
}
