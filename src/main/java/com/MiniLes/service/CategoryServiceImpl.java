package com.MiniLes.service;

import com.MiniLes.dto.category.CategoryGridDTO;
import com.MiniLes.dto.category.UpsertCategoryDTO;
import com.MiniLes.entity.Category;
import com.MiniLes.exception.NotFoundException;
import com.MiniLes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Category with number "+id+" not Found"));

    }

    @Override
    public void saveCategory(UpsertCategoryDTO dto) {

        Category category = new Category(
                dto.getName(),
                dto.getDescription()
        );

        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(UpsertCategoryDTO dto) {
        Optional<Category> theCategory = categoryRepository.findById(dto.getId());

        Category category = theCategory.get();

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        categoryRepository.save(category);

    }

    @Override
    public void deleteCategory(Long id) {
    Optional<Category> theCategory = categoryRepository.findById(id);

    categoryRepository.delete(theCategory.get());
    }

    @Override
    public List<CategoryGridDTO> findAllCategory(String name) {
        List<CategoryGridDTO> gridDTO = new LinkedList<>();
        categoryRepository.findAllByName(name).stream()
                .forEach(each -> gridDTO.add(each.convertToGrid()));
        return gridDTO;
    }
}
