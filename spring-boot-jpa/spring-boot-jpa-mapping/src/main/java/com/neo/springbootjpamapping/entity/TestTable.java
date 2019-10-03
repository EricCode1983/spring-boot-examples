package com.neo.springbootjpamapping.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="testTable")
@Data
public class TestTable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
}
