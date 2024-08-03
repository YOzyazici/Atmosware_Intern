package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.ExtractFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExtractFeedRepository extends JpaRepository<ExtractFeed, String> {

    @Query(value = "SELECT * FROM yasin.EXTRACT_FEED e WHERE " +
            "LOWER(e.feed_id) LIKE LOWER('%' || :searchTerm || '%') OR " +
            "LOWER(e.feed_desc) LIKE LOWER('%' || :searchTerm || '%') OR " +
            "LOWER(e.feed_file_name) LIKE LOWER('%' || :searchTerm || '%') OR " +
            "LOWER(e.ex_sql) LIKE LOWER('%' || :searchTerm || '%') OR " +
            "LOWER(e.post_script) LIKE LOWER('%' || :searchTerm || '%') OR " +
            "LOWER(DBMS_LOB.SUBSTR(e.prev_script, 4000, 1)) LIKE LOWER('%' || :searchTerm || '%')",
            nativeQuery = true)
    List<ExtractFeed> searchByAllFields(@Param("searchTerm") String searchTerm);

}
