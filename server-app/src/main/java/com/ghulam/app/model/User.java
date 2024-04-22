package com.ghulam.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    private String intro;

    /* todo - more */
}
