package com.MiniLes.service;

import com.MiniLes.dto.course.CourseGridDTO;
import com.MiniLes.dto.course.UpsertCourseDTO;
import com.MiniLes.entity.Course;

import java.util.Currency;
import java.util.List;

public interface CourseService {


    Course findById(Long id);
    void saveCourse(UpsertCourseDTO dto);

    void updateCourse(UpsertCourseDTO dto);

    void deleteCourse(Long id);

    List<CourseGridDTO> findAllCourse(String name);


}
