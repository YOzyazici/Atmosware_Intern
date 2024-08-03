package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.BatchmanService;
import com.example.intern.business.abstracts.ExtractFeedService;
import com.example.intern.business.abstracts.ParamsService;
import com.example.intern.business.dtos.BatchmanDto;
import com.example.intern.business.dtos.ExtractFeedDto;
import com.example.intern.business.dtos.ParamsDto;
import com.example.intern.business.messages.Messages;
import com.example.intern.business.queries.Queries;
import com.example.intern.core.business.abstracts.MessageService;
import com.example.intern.core.utils.exceptions.types.BusinessException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchManager {

    private final BatchmanService batchmanService;
    private final ExtractFeedService extractFeedService;
    private final ParamsService paramsService;
    private final MessageService messageService;

    public SearchResult searchByAllFields(String word) {

        List<BatchmanDto> batchmanResults = batchmanService.searchByAllFields(word);
        List<ExtractFeedDto> extractFeedResults = extractFeedService.searchByAllFields(word);

        ParamsDto batchmanParams = createParams("batchman", word, Queries.Batchman.batchmanQuery);
        ParamsDto extractFeedParams = createParams("extractFeed", word, Queries.ExtractFeed.extractFeedQuery);

        List<SearchResult.ResultWithQuery<BatchmanDto>> batchmanResultsWithQuery = batchmanResults.stream()
                .map(result -> new SearchResult.ResultWithQuery<>(result, Queries.Batchman.batchmanQuery))
                .collect(Collectors.toList());
        if (!batchmanResultsWithQuery.isEmpty()) {
            paramsService.saveParams(batchmanParams);
        }

        List<SearchResult.ResultWithQuery<ExtractFeedDto>> extractFeedResultsWithQuery = extractFeedResults.stream()
                .map(result -> new SearchResult.ResultWithQuery<>(result, Queries.ExtractFeed.extractFeedQuery))
                .collect(Collectors.toList());
        if (!extractFeedResultsWithQuery.isEmpty()) {
            paramsService.saveParams(extractFeedParams);
        }

        return new SearchResult(word, batchmanResultsWithQuery, extractFeedResultsWithQuery);
    }

    private ParamsDto createParams(String prefix, String searchTerm, String query) {
        ParamsDto paramsDto = new ParamsDto();
        paramsDto.setId(prefix + "_" + System.currentTimeMillis());
        paramsDto.setWord(searchTerm);
        paramsDto.setSqlQuery(createClob(query));
        return paramsDto;
    }

    private Clob createClob(String data) {
        try {
            return new javax.sql.rowset.serial.SerialClob(data.toCharArray());
        } catch (SQLException e) {
            throw new BusinessException(messageService.getMessage(Messages.Search.CreateClob));
        }
    }

    public static class SearchResult {
        private String searchTerm;
        private List<ResultWithQuery<BatchmanDto>> batchmanResultsWithQuery;
        private List<ResultWithQuery<ExtractFeedDto>> extractFeedResultsWithQuery;

        public SearchResult(String searchTerm, List<ResultWithQuery<BatchmanDto>> batchmanResultsWithQuery,
                            List<ResultWithQuery<ExtractFeedDto>> extractFeedResultsWithQuery) {
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

        public List<ResultWithQuery<BatchmanDto>> getBatchmanResultsWithQuery() {
            return batchmanResultsWithQuery;
        }

        public void setBatchmanResultsWithQuery(List<ResultWithQuery<BatchmanDto>> batchmanResultsWithQuery) {
            this.batchmanResultsWithQuery = batchmanResultsWithQuery;
        }

        public List<ResultWithQuery<ExtractFeedDto>> getExtractFeedResultsWithQuery() {
            return extractFeedResultsWithQuery;
        }

        public void setExtractFeedResultsWithQuery(List<ResultWithQuery<ExtractFeedDto>> extractFeedResultsWithQuery) {
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
