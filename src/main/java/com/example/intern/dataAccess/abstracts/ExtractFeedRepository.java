package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.ExtractFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExtractFeedRepository extends JpaRepository<ExtractFeed, String> {

    @Query(value = "SELECT * FROM yasin.EXTRACT_FEED e WHERE " +
            "(:searchTerms) IS NULL OR " +
            "EXISTS (SELECT 1 FROM (SELECT REGEXP_SUBSTR(:searchTerms, '[^ ]+', 1, LEVEL) AS keyword FROM dual CONNECT BY REGEXP_SUBSTR(:searchTerms, '[^ ]+', 1, LEVEL) IS NOT NULL) WHERE " +
            "LOWER(e.feed_id) LIKE LOWER('%' || keyword || '%') OR " +
            "LOWER(e.feed_desc) LIKE LOWER('%' || keyword || '%') OR " +
            "LOWER(e.feed_file_name) LIKE LOWER('%' || keyword || '%') OR " +
            "LOWER(e.ex_sql) LIKE LOWER('%' || keyword || '%') OR " +
            "LOWER(e.post_script) LIKE LOWER('%' || keyword || '%') OR " +
            "LOWER(DBMS_LOB.SUBSTR(e.prev_script, 4000, 1)) LIKE LOWER('%' || keyword || '%'))",
            nativeQuery = true)
    List<ExtractFeed> searchByAllFields(@Param("searchTerms") String searchTerms);

}
