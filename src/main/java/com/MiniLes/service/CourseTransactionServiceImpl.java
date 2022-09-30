package com.MiniLes.service;

import com.MiniLes.dto.courseTransaction.CourseTransactionGridDTO;
import com.MiniLes.dto.courseTransaction.UpsertCourseTransactionDTO;
import com.MiniLes.entity.Course;
import com.MiniLes.entity.CourseTransaction;
import com.MiniLes.exception.NotFoundException;
import com.MiniLes.repository.CourseRepository;
import com.MiniLes.repository.CourseTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CourseTransactionServiceImpl implements CourseTransactionService{

    @Autowired
    private CourseTransactionRepository courseTransactionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Page<CourseTransaction> getAllTransaction(Pageable pageable) {

        Page<CourseTransaction> courseTransactionPage = courseTransactionRepository.findAllByPage(pageable);
        return courseTransactionPage;
    }

    @Override
    public CourseTransaction findById(Long id) {
        return courseTransactionRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Course Transaction with number "+id+" not Found"));

    }

    @Override
    public void saveCourseTransaction(UpsertCourseTransactionDTO dto) {

        Optional<Course> theCourse = courseRepository.findById(dto.getCourseId());

        Course course = theCourse.get();

        BigDecimal bill = course.getPrice();


        CourseTransaction courseTransaction = new CourseTransaction(
                bill,
                dto.getIsPending(),
                dto.getIsExpired(),
                dto.getIsConfirmed(),
                dto.getStudentId(),
                dto.getTutorId(),
                dto.getCourseId()
        );
        courseTransactionRepository.save(courseTransaction);
    }

    @Override
    public void updateCourseTransaction(UpsertCourseTransactionDTO dto) {
        Optional<CourseTransaction> theCourseTransaction = courseTransactionRepository.findById(dto.getId());

        CourseTransaction courseTransaction = theCourseTransaction.get();

        Optional<Course> theCourse = courseRepository.findById(courseTransaction.getCourseId());

        Course course = theCourse.get();

        BigDecimal bill = course.getPrice();

        courseTransaction.setBill(bill);
        courseTransaction.setIsPending(dto.getIsPending());
        courseTransaction.setIsExpired(dto.getIsExpired());
        courseTransaction.setIsConfirmed(dto.getIsConfirmed());
        courseTransaction.setStudentId(dto.getStudentId());
        courseTransaction.setTutorId(dto.getTutorId());
        courseTransaction.setCourseId(dto.getCourseId());

        courseTransactionRepository.save(courseTransaction);
    }
}
