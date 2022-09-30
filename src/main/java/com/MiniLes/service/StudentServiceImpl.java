package com.MiniLes.service;

import com.MiniLes.dto.student.StudentGridDTO;
import com.MiniLes.dto.student.UpsertStudentDTO;
import com.MiniLes.entity.Student;
import com.MiniLes.exception.NotFoundException;
import com.MiniLes.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Student with number "+id+" not Found"));

    }

    @Override
    public void saveStudent(UpsertStudentDTO dto) {

        Student student = new Student(
                dto.getName(),
                dto.getGender(),
                dto.getAddress(),
                dto.getBirthDate(),
                dto.getHobby()

        );

        studentRepository.save(student);
    }

    @Override
    public void updateStudent(UpsertStudentDTO dto) {
        Optional<Student> theStudent = studentRepository.findById(dto.getId());

        Student student =theStudent.get();

        student.setName(dto.getName());
        student.setGender(dto.getGender());
        student.setAddress(dto.getAddress());
        student.setBirthDate(dto.getBirthDate());
        student.setHobby(dto.getHobby());

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> theStudent = studentRepository.findById(id);

        studentRepository.delete(theStudent.get());

    }

    @Override
    public List<StudentGridDTO> findAllStudent(String name) {
        List<StudentGridDTO> gridDTO = new LinkedList<>();
        studentRepository.findByName(name).stream()
                .forEach(each -> gridDTO.add(each.convertToGrid()));

        return gridDTO;
    }
}
