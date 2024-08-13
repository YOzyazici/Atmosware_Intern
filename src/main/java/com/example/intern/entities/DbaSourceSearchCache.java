package com.example.intern.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "DBA_SOURCE_SEARCH_CACHE", schema = "burak")
public class DbaSourceSearchCache {
    @Id
    private String id;
    private String keyword;
    private String line;
    private String result;

    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
