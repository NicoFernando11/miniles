package com.MiniLes.service;

import com.MiniLes.dto.course.CourseGridDTO;
import com.MiniLes.dto.course.UpsertCourseDTO;
import com.MiniLes.entity.Course;
import com.MiniLes.exception.NotFoundException;
import com.MiniLes.repository.CourseRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(
                        ()-> new NotFoundException("Course with number "+id+" not Found")
                        );
    }

    @Override
    public void saveCourse(UpsertCourseDTO dto) {
        Course entity = new Course(
                dto.getName(),
                dto.getStudyDuration(),
                dto.getIsAvaiable(),
                dto.getIsOnProgress(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getCategoryId()
        );

        courseRepository.save(entity);
    }

    @Override
    public void updateCourse(UpsertCourseDTO dto) {
        Optional<Course> theCourse = courseRepository.findById(dto.getId());

        Course course = theCourse.get();

        course.setName(dto.getName());
        course.setStudyDuration(dto.getStudyDuration());
        course.setIsAvaiable(dto.getIsAvaiable());
        course.setIsOnProgress(dto.getIsOnProgress());
        course.setDescription(dto.getDescription());
        course.setPrice(dto.getPrice());
        course.setCategoryId(dto.getCategoryId());


        courseRepository.save(course);


    }

    @Override
    public void deleteCourse(Long id) {
        Optional<Course> theCourse = courseRepository.findById(id);


        courseRepository.delete(theCourse.get());
    }

    @Override
    public List<CourseGridDTO> findAllCourse(String name) {

        List<CourseGridDTO> gridDTO = new LinkedList<>();
        courseRepository.findByName(name).stream()
                .forEach(each -> gridDTO.add(each.convertToGrid()));




        return gridDTO;
    }


}
