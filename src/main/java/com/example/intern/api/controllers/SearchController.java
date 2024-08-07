package com.example.intern.api.controllers;

import com.example.intern.business.concretes.SearchManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/searchRest")
public class SearchController {

    private final SearchManager searchManager;

    @GetMapping
    public SearchManager.SearchResult searchByAllFields(@RequestParam String word) {
        SearchManager.SearchResult searchResult = searchManager.searchByAllFields(word);
        return searchResult;
    }

}
