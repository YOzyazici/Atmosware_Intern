package com.example.intern.api.controllers;

import com.example.intern.business.abstracts.DbaSourceService;
import com.example.intern.entities.DbaSource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dbaSource")
public class DbaSourceController {

    private final DbaSourceService dbaSourceService;

    @GetMapping("/search")
    public List<DbaSource> search(@RequestParam String keyword) {
        return dbaSourceService.searchByKeyword(keyword);
    }
}
