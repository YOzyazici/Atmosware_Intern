package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.Batchman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatchmanRepository extends JpaRepository<Batchman, String> {
    @Query(value = "SELECT * FROM aziz.BATCHMAN b WHERE " +
            "LOWER(b.batch_id) LIKE LOWER('%' || :searchTerm || '%') OR " +
            "LOWER(b.batch_desc) LIKE LOWER('%' || :searchTerm || '%') OR " +
            "LOWER(b.script) LIKE LOWER('%' || :searchTerm || '%') OR " +
            "LOWER(DBMS_LOB.SUBSTR(b.script_clob, 4000, 1)) LIKE LOWER('%' || :searchTerm || '%')",
            nativeQuery = true)
    List<Batchman> searchByAllFields(@Param("searchTerm") String searchTerm);
}
