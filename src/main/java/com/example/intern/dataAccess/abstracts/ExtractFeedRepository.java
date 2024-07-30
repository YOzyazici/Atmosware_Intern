package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.ExtractFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExtractFeedRepository extends JpaRepository<ExtractFeed, String> {

    @Query("SELECT e FROM ExtractFeed e WHERE " +
            "LOWER(e.feedId) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.feedDesc) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.feedFileName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.feedFileExt) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<ExtractFeed> searchByAllFields(@Param("searchTerm") String searchTerm);
}
