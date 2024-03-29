package com.example.chap07.start.inheritance.mapped;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;
}
