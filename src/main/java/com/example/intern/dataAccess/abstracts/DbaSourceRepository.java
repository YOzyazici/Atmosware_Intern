package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.DbaSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DbaSourceRepository extends JpaRepository<DbaSource, Long> {

    @Query("SELECT ds FROM DbaSource ds WHERE UPPER(ds.text) LIKE UPPER(:keyword) AND ds.owner <> 'SYS' ORDER BY ds.owner, ds.name DESC")
    List<DbaSource> findByKeyword(@Param("keyword") String keyword);
}
