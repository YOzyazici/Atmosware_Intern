package com.example.intern.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DBA_SOURCE")
public class DbaSource {

    @Id
    @Column(name = "LINE")
    private Long line;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "TEXT")
    private String text;

}
