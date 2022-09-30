package com.MiniLes.repository;

import com.MiniLes.dto.course.CourseGridDTO;
import com.MiniLes.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query(value = """
            Select * from Course where CourseName Like %:name%
            """, nativeQuery = true)
    List<Course> findByName(@Param("name") String name);
}