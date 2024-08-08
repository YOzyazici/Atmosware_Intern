package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.DbaSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DbaSourceRepository extends JpaRepository<DbaSource, Long> {

    @Query(value = "SELECT * FROM dba_source " +
            "WHERE owner <> 'SYS' " +
            "AND owner <> 'APEX_040000' " +
            "AND ( " +
            "    EXISTS ( " +
            "        SELECT 1 " +
            "        FROM ( " +
            "            SELECT REGEXP_SUBSTR(:searchTerms, '[^,]+', 1, LEVEL) AS keyword " +
            "            FROM dual " +
            "            CONNECT BY REGEXP_SUBSTR(:searchTerms, '[^,]+', 1, LEVEL) IS NOT NULL " +
            "        ) t " +
            "        WHERE UPPER(dba_source.text) LIKE UPPER('%' || t.keyword || '%') " +
            "    ) " +
            ") " +
            "ORDER BY owner, name DESC",
            nativeQuery = true)
    List<DbaSource> searchByAllDb(@Param("searchTerms") String searchTerms);
}
