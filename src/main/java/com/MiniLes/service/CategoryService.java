package com.MiniLes.service;

import com.MiniLes.dto.category.CategoryGridDTO;
import com.MiniLes.dto.category.UpsertCategoryDTO;
import com.MiniLes.dto.course.UpsertCourseDTO;
import com.MiniLes.entity.Category;
import com.MiniLes.entity.Course;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);
    void saveCategory(UpsertCategoryDTO dto);

    void updateCategory(UpsertCategoryDTO dto);

    void deleteCategory(Long id);

    List<CategoryGridDTO> findAllCategory(String name);
}
