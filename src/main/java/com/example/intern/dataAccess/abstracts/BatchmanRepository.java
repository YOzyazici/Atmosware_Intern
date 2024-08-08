package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.Batchman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatchmanRepository extends JpaRepository<Batchman, String> {
    @Query(value = "SELECT * FROM aziz.BATCHMAN b WHERE " +
            "(:searchTerms) IS NULL OR " +
            "EXISTS (SELECT 1 FROM (SELECT REGEXP_SUBSTR(:searchTerms, '[^,]+', 1, LEVEL) AS keyword FROM dual CONNECT BY REGEXP_SUBSTR(:searchTerms, '[^,]+', 1, LEVEL) IS NOT NULL) WHERE " +
            "LOWER(b.batch_id) LIKE LOWER('%' || keyword || '%') OR " +
            "LOWER(b.batch_desc) LIKE LOWER('%' || keyword || '%') OR " +
            "LOWER(b.script) LIKE LOWER('%' || keyword || '%') OR " +
            "LOWER(DBMS_LOB.SUBSTR(b.script_clob, 4000, 1)) LIKE LOWER('%' || keyword || '%'))",
            nativeQuery = true)
    List<Batchman> searchByAllFields(@Param("searchTerms") String searchTerms);
}
