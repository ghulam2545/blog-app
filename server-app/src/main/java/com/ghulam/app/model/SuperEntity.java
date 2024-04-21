package com.ghulam.app.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class SuperEntity {

    @Id
    @GeneratedValue
    private Long id;
}
