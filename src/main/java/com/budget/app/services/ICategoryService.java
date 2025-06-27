package com.budget.app.services;

import com.budget.app.dto.CategoryDto;
import com.budget.app.entity.Category;

import java.util.List;


public interface ICategoryService {
    CategoryDto getCategoryOfUser(long categoryId, long userId) throws Exception;

    List<CategoryDto> findAll() throws Exception;

    void save(CategoryDto category) throws Exception;

    Category findByUserId(long categoryId, long userId) throws Exception;
}
