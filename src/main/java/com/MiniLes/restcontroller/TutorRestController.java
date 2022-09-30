package com.MiniLes.restcontroller;

import com.MiniLes.dto.student.UpsertStudentDTO;
import com.MiniLes.dto.tutor.TutorGridDTO;
import com.MiniLes.dto.tutor.UpsertTutorDTO;
import com.MiniLes.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutor")
public class TutorRestController {

    @Autowired
    private TutorService tutorService;

    @GetMapping("/index")
    public ResponseEntity<Object> getAllTutor (@RequestParam(defaultValue = "") String name)
    {
        List<TutorGridDTO> allTutor = tutorService.findAllTutor(name);

        return new ResponseEntity<>(allTutor, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestBody UpsertTutorDTO dto)
    {
        tutorService.saveTutor(dto);
        return new ResponseEntity<>("Data Successfully Added", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCourse(@RequestBody UpsertTutorDTO dto)
    {
        tutorService.findById(dto.getId());
        tutorService.updateTutor(dto);
        return new ResponseEntity<>("Data Successfully Updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id)
    {
        tutorService.findById(id);
        tutorService.deleteTutor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tutor with "+ id + " is Deleted");
    }

}
