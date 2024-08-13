package com.example.intern.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "BATCHMAN_SEARCH_CACHE", schema = "burak")
public class BatchmanSearchCache {
    @Id
    @Column(name = "id")
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
