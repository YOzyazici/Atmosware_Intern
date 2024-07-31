package com.example.intern.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Clob;
import java.util.Date;

@Entity
@Data
@Table(name = "PARAMS", schema = "burak")
public class Params {
    @Id
    private String id;
    private String name;
    @Lob
    @Column(name = "sql_query")
    private Clob sqlQuery;
}
