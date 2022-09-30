package com.MiniLes.service;

import com.MiniLes.dto.course.UpsertCourseDTO;
import com.MiniLes.dto.student.StudentGridDTO;
import com.MiniLes.dto.student.UpsertStudentDTO;
import com.MiniLes.entity.Course;
import com.MiniLes.entity.Student;

import java.util.List;

public interface StudentService {

    Student findById(Long id);
    void saveStudent(UpsertStudentDTO dto);

    void updateStudent(UpsertStudentDTO dto);

    void deleteStudent(Long id);
    List<StudentGridDTO> findAllStudent(String name);
}
