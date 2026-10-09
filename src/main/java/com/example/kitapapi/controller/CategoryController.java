package com.example.kitapapi.controller;

import com.example.kitapapi.entity.Category;
import com.example.kitapapi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
//get kategori listeleme
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
//post kategori ekleme
    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
}