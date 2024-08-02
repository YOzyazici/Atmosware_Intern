package com.example.intern.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Clob;

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

    @Column(name = "EX_SQL")
    private String exSql;

    @Column(name = "POST_SCRIPT")
    private String postScript;

    @Lob
    @Column(name = "PREV_SCRIPT")
    private Clob prevScript;
}
