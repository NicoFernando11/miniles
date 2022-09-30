package com.MiniLes.restcontroller;

import com.MiniLes.dto.category.CategoryGridDTO;
import com.MiniLes.dto.category.UpsertCategoryDTO;
import com.MiniLes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Object> addCategory(@RequestBody UpsertCategoryDTO dto)
    {
       categoryService.saveCategory(dto);
        return new ResponseEntity<>("Data Category Already added", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCategory(@RequestBody UpsertCategoryDTO dto)
    {
        categoryService.findById(dto.getId());
        categoryService.updateCategory(dto);
        return new ResponseEntity<>("Data Successfully Updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id)
    {
        categoryService.findById(id);
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body("Category with "+ id + " is Deleted");
    }


    @GetMapping("/index")
    public ResponseEntity<Object> getAllCategory (@RequestParam(defaultValue = "") String name)
    {
        List<CategoryGridDTO> allCategory = categoryService.findAllCategory(name);

        return new ResponseEntity<>(allCategory, HttpStatus.OK);
    }
}
