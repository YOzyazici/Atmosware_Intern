package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.business.abstracts.ExtractFeedService;
import com.example.intern.entities.Batchman;
import com.example.intern.entities.ExtractFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchManager {

    private final BatchmanService batchmanService;
    private final ExtractFeedService extractFeedService;


    public SearchResult searchByAllFields(String searchTerm) {
        List<Batchman> batchmanResults = batchmanService.searchByAllFields(searchTerm);
        List<ExtractFeed> extractFeedResults = extractFeedService.searchByAllFields(searchTerm);

        return new SearchResult(batchmanResults, extractFeedResults);
    }

    public static class SearchResult {
        private List<Batchman> batchmanResults;
        private List<ExtractFeed> extractFeedResults;

        public SearchResult(List<Batchman> batchmanResults, List<ExtractFeed> extractFeedResults) {
            this.batchmanResults = batchmanResults;
            this.extractFeedResults = extractFeedResults;
        }

        public List<Batchman> getBatchmanResults() {
            return batchmanResults;
        }

        public void setBatchmanResults(List<Batchman> batchmanResults) {
            this.batchmanResults = batchmanResults;
        }

        public List<ExtractFeed> getExtractFeedResults() {
            return extractFeedResults;
        }

        public void setExtractFeedResults(List<ExtractFeed> extractFeedResults) {
            this.extractFeedResults = extractFeedResults;
        }
    }
}
