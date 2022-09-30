package com.MiniLes.restcontroller;

import com.MiniLes.dto.course.CourseGridDTO;
import com.MiniLes.dto.course.UpsertCourseDTO;
import com.MiniLes.entity.Course;
import com.MiniLes.exception.NotFoundException;
import com.MiniLes.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/index")
    public ResponseEntity<Object> getAllCourse(@RequestParam(defaultValue = "") String name) {

        List<CourseGridDTO> allCourse = courseService.findAllCourse(name);

        return new ResponseEntity<>(allCourse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addCourse(@RequestBody UpsertCourseDTO dto) {
        courseService.saveCourse(dto);
        return new ResponseEntity<>("Data Course already added", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCourse(@RequestBody UpsertCourseDTO dto) {
        courseService.findById(dto.getId());
        courseService.updateCourse(dto);
        return new ResponseEntity<>("Data Successfully Updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
        courseService.findById(id);
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("Course with " + id + " is Deleted");
    }

}
