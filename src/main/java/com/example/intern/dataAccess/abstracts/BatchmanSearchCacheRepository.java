package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.BatchmanSearchCache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BatchmanSearchCacheRepository extends JpaRepository<BatchmanSearchCache,String> {
    List<BatchmanSearchCache> findAllByKeyword(String keyword);
}
