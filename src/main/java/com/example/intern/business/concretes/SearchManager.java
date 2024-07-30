package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.business.abstracts.ExtractFeedService;
import com.example.intern.business.abstracts.ParamsService;
import com.example.intern.entities.Batchman;
import com.example.intern.entities.ExtractFeed;
import com.example.intern.entities.Params;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchManager {

    private final BatchmanService batchmanService;
    private final ExtractFeedService extractFeedService;
    private final ParamsService paramsService;


    public SearchResult searchByAllFields(String searchTerm) {
        List<Batchman> batchmanResults = batchmanService.searchByAllFields(searchTerm);
        List<ExtractFeed> extractFeedResults = extractFeedService.searchByAllFields(searchTerm);

        String batchmanQuery = "SELECT b FROM Batchman b WHERE " +
                "LOWER(b.batchId) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(b.batchDesc) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(b.batchName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(b.batchChapter) LIKE LOWER(CONCAT('%', :searchTerm, '%'))";

        String extractFeedQuery = "SELECT e FROM ExtractFeed e WHERE " +
                "LOWER(e.feedId) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(e.feedDesc) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(e.feedFileName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(e.feedFileExt) LIKE LOWER(CONCAT('%', :searchTerm, '%'))";

        // Params objesi oluştur ve kaydet
        Params batchmanParams = new Params();
        batchmanParams.setId("batchman_" + System.currentTimeMillis()); // ID olarak zaman damgası kullanabilirsiniz
        batchmanParams.setName("Batchman Search");
        batchmanParams.setSqlQuery(batchmanQuery);

        Params extractFeedParams = new Params();
        extractFeedParams.setId("extractFeed_" + System.currentTimeMillis()); // ID olarak zaman damgası kullanabilirsiniz
        extractFeedParams.setName("ExtractFeed Search");
        extractFeedParams.setSqlQuery(extractFeedQuery);

        paramsService.saveParams(batchmanParams);
        paramsService.saveParams(extractFeedParams);

        return new SearchResult(searchTerm, batchmanQuery, extractFeedQuery, batchmanResults, extractFeedResults);
    }

    public static class SearchResult {
        private String searchTerm;
        private String batchmanQuery;
        private String extractFeedQuery;
        private List<Batchman> batchmanResults;
        private List<ExtractFeed> extractFeedResults;

        public SearchResult(String searchTerm, String batchmanQuery, String extractFeedQuery,
                            List<Batchman> batchmanResults, List<ExtractFeed> extractFeedResults) {
            this.searchTerm = searchTerm;
            this.batchmanQuery = batchmanQuery;
            this.extractFeedQuery = extractFeedQuery;
            this.batchmanResults = batchmanResults;
            this.extractFeedResults = extractFeedResults;
        }

        public String getSearchTerm() {
            return searchTerm;
        }

        public void setSearchTerm(String searchTerm) {
            this.searchTerm = searchTerm;
        }

        public String getBatchmanQuery() {
            return batchmanQuery;
        }

        public void setBatchmanQuery(String batchmanQuery) {
            this.batchmanQuery = batchmanQuery;
        }

        public String getExtractFeedQuery() {
            return extractFeedQuery;
        }

        public void setExtractFeedQuery(String extractFeedQuery) {
            this.extractFeedQuery = extractFeedQuery;
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
