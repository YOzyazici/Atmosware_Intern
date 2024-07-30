package com.example.intern.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "EXTRACT_FEED", schema = "yasin")
public class ExtractFeed {
    @Id
    @Column(name = "FEED_ID")
    private String feedId;

    @Column(name = "FEED_DESC")
    private String feedDesc;

    @Column(name = "FEED_FILE_NAME")
    private String feedFileName;

    @Column(name = "FEED_FILE_EXT")
    private String feedFileExt;
}
