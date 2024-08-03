package com.example.intern.api.controllers;

import com.example.intern.business.concretes.SearchManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SearchPageController {

    private final SearchManager searchManager;

    @GetMapping("/search")
    public String searchPage(@RequestParam(name = "word", required = false) String word, Model model) {
        if (word != null && !word.isEmpty()) {
            SearchManager.SearchResult searchResult = searchManager.searchByAllFields(word);
            model.addAttribute("searchResult", searchResult);
        }
        return "search";
    }
}
