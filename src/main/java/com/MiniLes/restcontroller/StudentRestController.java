package com.MiniLes.restcontroller;

import com.MiniLes.dto.student.StudentGridDTO;
import com.MiniLes.dto.student.UpsertStudentDTO;
import com.MiniLes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/index")

    public ResponseEntity<Object> index(@RequestParam(defaultValue = "") String name)
    {
        List<StudentGridDTO> allStudent = studentService.findAllStudent(name);

        return new ResponseEntity<>(allStudent, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestBody UpsertStudentDTO dto)
    {
        studentService.saveStudent(dto);
        return new ResponseEntity<>("Data Successfully Added", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCourse(@RequestBody UpsertStudentDTO dto)
    {
        studentService.findById(dto.getId());
        studentService.updateStudent(dto);
        return new ResponseEntity<>("Data Successfully Updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id)
    {
        studentService.findById(id);
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Student with "+ id + " is Deleted");
    }

}
