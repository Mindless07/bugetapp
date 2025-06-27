package com.budget.app.services;

import com.budget.app.dto.CategoryDto;
import com.budget.app.entity.Category;
import com.budget.app.exception.NoCategoryFound;
import com.budget.app.exception.UserNotFoundException;

import java.util.List;


public interface ICategoryService {
    CategoryDto getCategoryOfUser(long categoryId, long userId) throws Exception;

    List<CategoryDto> findAll() ;

    void save(CategoryDto category) throws UserNotFoundException;

    Category findByUserId(long categoryId, long userId) throws NoCategoryFound;
}
