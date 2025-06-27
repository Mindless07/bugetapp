package com.budget.app.controller;

import com.budget.app.dto.CategoryDto;
import com.budget.app.entity.Category;
import com.budget.app.services.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService ICategoryService;

    @GetMapping
    public List<CategoryDto> getCaregories() throws Exception {
        return this.ICategoryService.findAll();
    }

    @PostMapping
    public ResponseEntity<HttpStatusCode> saveCategory(@RequestBody CategoryDto category) throws Exception {
        this.ICategoryService.save(category);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}