package com.MiniLes.repository;

import com.MiniLes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = """
            Select * from Category where Name Like %:name%
            """,nativeQuery = true)
    List<Category> findAllByName(String name);
}