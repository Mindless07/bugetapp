package com.budget.app.controller;

import com.budget.app.entity.Category;
import com.budget.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping
    public List<Category> getCaregories() {
        return this.categoryRepository.findAll();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return this.categoryRepository.save(category);
    }

}