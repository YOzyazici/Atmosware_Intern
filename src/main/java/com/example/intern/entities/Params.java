package com.example.intern.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Clob;
import java.util.Date;

@Entity
@Data
@Table(name = "Params", schema = "burak")
public class Params {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "WORD")
    private String word;

    @Lob
    @Column(name = "sql_query")
    private Clob sqlQuery;
}
