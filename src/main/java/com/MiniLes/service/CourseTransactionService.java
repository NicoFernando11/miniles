package com.MiniLes.service;

import com.MiniLes.dto.course.UpsertCourseDTO;
import com.MiniLes.dto.courseTransaction.CourseTransactionGridDTO;
import com.MiniLes.dto.courseTransaction.UpsertCourseTransactionDTO;
import com.MiniLes.entity.Course;
import com.MiniLes.entity.CourseTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseTransactionService {

    CourseTransaction findById(Long id);
    void saveCourseTransaction(UpsertCourseTransactionDTO dto);

    void updateCourseTransaction(UpsertCourseTransactionDTO  dto);

    Page<CourseTransaction> getAllTransaction(Pageable pageable);
}
