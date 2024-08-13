package com.example.intern.dataAccess.abstracts;

import com.example.intern.entities.DbaSourceSearchCache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DbaSourceSearchCacheRepository extends JpaRepository<DbaSourceSearchCache,String> {
    List<DbaSourceSearchCache> findAllByKeyword(String keyword);
}
