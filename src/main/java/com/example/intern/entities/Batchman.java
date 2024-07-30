package com.example.intern.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.security.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "BATCHMAN", schema = "aziz")
public class Batchman {
    @Id
    @Column(name = "BATCH_ID")
    private String batchId;

    @Column(name = "BATCH_DESC")
    private String batchDesc;

    @Column(name = "BATCH_NAME")
    private String batchName;

    @Column(name = "BATCH_CHAPTER")
    private String batchChapter;
}
