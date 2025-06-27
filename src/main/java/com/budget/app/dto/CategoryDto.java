package com.budget.app.dto;

import com.budget.app.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private String label;

    public CategoryDto(Category category) {
        this.label = category.getLabel();
    }
}


