package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.business.abstracts.ExtractFeedService;
import com.example.intern.business.abstracts.ParamsService;
import com.example.intern.business.queries.Queries;
import com.example.intern.entities.Batchman;
import com.example.intern.entities.ExtractFeed;
import com.example.intern.entities.Params;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Clob;
import java.sql.SQLException;
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

        // Params objesi oluştur
        Params batchmanParams = new Params();
        batchmanParams.setId("batchman_" + System.currentTimeMillis());
        batchmanParams.setName(searchTerm);
        batchmanParams.setSqlQuery(createClob(Queries.Batchman.batchmanQuery));

        Params extractFeedParams = new Params();
        extractFeedParams.setId("extractFeed_" + System.currentTimeMillis());
        extractFeedParams.setName(searchTerm);
        extractFeedParams.setSqlQuery(createClob(Queries.ExtractFeed.extractFeedQuery));

        // Her sonuç için kullanılan sorguyu set et
        List<SearchResult.ResultWithQuery<Batchman>> batchmanResultsWithQuery = batchmanResults.stream()
                .map(result -> new SearchResult.ResultWithQuery<>(result, Queries.Batchman.batchmanQuery))
                .toList();
        if (!batchmanResultsWithQuery.isEmpty()){
            paramsService.saveParams(batchmanParams);
        }

        List<SearchResult.ResultWithQuery<ExtractFeed>> extractFeedResultsWithQuery = extractFeedResults.stream()
                .map(result -> new SearchResult.ResultWithQuery<>(result, Queries.ExtractFeed.extractFeedQuery))
                .toList();
        if (!extractFeedResultsWithQuery.isEmpty()){
            paramsService.saveParams(extractFeedParams);
        }

        return new SearchResult(searchTerm, batchmanResultsWithQuery, extractFeedResultsWithQuery);
    }

    private Clob createClob(String data) {
        try {
            return new javax.sql.rowset.serial.SerialClob(data.toCharArray());
        } catch (SQLException e) {
            throw new RuntimeException("Error creating Clob object", e);
        }
    }

    public static class SearchResult {
        private String searchTerm;
        private List<ResultWithQuery<Batchman>> batchmanResultsWithQuery;
        private List<ResultWithQuery<ExtractFeed>> extractFeedResultsWithQuery;

        public SearchResult(String searchTerm, List<ResultWithQuery<Batchman>> batchmanResultsWithQuery,
                            List<ResultWithQuery<ExtractFeed>> extractFeedResultsWithQuery) {
            this.searchTerm = searchTerm;
            this.batchmanResultsWithQuery = batchmanResultsWithQuery;
            this.extractFeedResultsWithQuery = extractFeedResultsWithQuery;
        }

        public String getSearchTerm() {
            return searchTerm;
        }

        public void setSearchTerm(String searchTerm) {
            this.searchTerm = searchTerm;
        }

        public List<ResultWithQuery<Batchman>> getBatchmanResultsWithQuery() {
            return batchmanResultsWithQuery;
        }

        public void setBatchmanResultsWithQuery(List<ResultWithQuery<Batchman>> batchmanResultsWithQuery) {
            this.batchmanResultsWithQuery = batchmanResultsWithQuery;
        }

        public List<ResultWithQuery<ExtractFeed>> getExtractFeedResultsWithQuery() {
            return extractFeedResultsWithQuery;
        }

        public void setExtractFeedResultsWithQuery(List<ResultWithQuery<ExtractFeed>> extractFeedResultsWithQuery) {
            this.extractFeedResultsWithQuery = extractFeedResultsWithQuery;
        }

        public static class ResultWithQuery<T> {
            private T result;
            private String query;

            public ResultWithQuery(T result, String query) {
                this.result = result;
                this.query = query;
            }

            public T getResult() {
                return result;
            }

            public void setResult(T result) {
                this.result = result;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }
        }
    }
}
