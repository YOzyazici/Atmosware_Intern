package com.example.intern.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;
import java.sql.Clob;
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

    @Column(name = "SCRIPT")
    private String script;

    @Lob
    @Column(name = "SCRIPT_CLOB")
    private Clob scriptClob;
}
