package com.example.intern.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String sqlQuery;
}
