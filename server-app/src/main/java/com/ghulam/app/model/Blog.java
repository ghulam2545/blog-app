package com.ghulam.app.model;

import com.ghulam.app.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "blogs")
public class Blog implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @Column(length = 500)
    private String brief;

    @Column(length = 10000)
    private String content;
    private String image;
    private String author;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private LocalDate createdAt;
    private Integer likes;
}
