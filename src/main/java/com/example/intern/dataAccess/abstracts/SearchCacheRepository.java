package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.SearchCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchCacheRepository extends JpaRepository<SearchCache,String> {

    @Query("SELECT sc FROM SearchCache sc WHERE LOWER(sc.line) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(sc.keyword) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<SearchCache> findAllByLineContainingOrKeywordContaining(@Param("keyword") String keyword);
}
