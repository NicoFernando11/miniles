package com.MiniLes.service;

import com.MiniLes.dto.student.UpsertStudentDTO;
import com.MiniLes.dto.tutor.TutorGridDTO;
import com.MiniLes.dto.tutor.UpsertTutorDTO;
import com.MiniLes.entity.Course;
import com.MiniLes.entity.Tutor;

import java.util.List;

public interface TutorService {
    Tutor findById(Long id);
    void saveTutor(UpsertTutorDTO dto);

    void updateTutor(UpsertTutorDTO dto);

    void deleteTutor(Long id);

    List<TutorGridDTO> findAllTutor(String name);
}
