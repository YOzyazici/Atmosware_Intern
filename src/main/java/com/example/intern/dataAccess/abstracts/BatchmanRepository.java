package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.Batchman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatchmanRepository extends JpaRepository<Batchman, String> {
    @Query("SELECT b FROM Batchman b WHERE " +
            "LOWER(b.batchId) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(b.batchDesc) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Batchman> searchByAllFields(@Param("searchTerm") String searchTerm);
}
