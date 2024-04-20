package com.ghulam.app.dtos;

import com.ghulam.app.enums.Category;

/* todo - add validations too! */
public record BlogRequest(
        String title,
        String brief,
        String content,
        String image,
        String author,
        Category category
) {
}
