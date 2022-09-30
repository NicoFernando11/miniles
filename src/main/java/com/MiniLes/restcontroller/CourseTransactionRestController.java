package com.MiniLes.restcontroller;

import com.MiniLes.dto.courseTransaction.CourseTransactionGridDTO;
import com.MiniLes.dto.courseTransaction.UpsertCourseTransactionDTO;
import com.MiniLes.entity.CourseTransaction;
import com.MiniLes.service.CourseTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaction")
public class CourseTransactionRestController {

    @Autowired
    private CourseTransactionService courseTransactionService;

    @GetMapping("/index")
    public ResponseEntity<Object> allTransaction(@RequestParam(defaultValue = "1") Integer page)
    {
        Pageable pageable = PageRequest.of(page-1,2, Sort.by("id"));
        Page<CourseTransaction> courseTransactions = courseTransactionService.getAllTransaction(pageable);

        Page<CourseTransactionGridDTO> transactionGridDTO = new PageImpl<>(courseTransactions.stream().map(each -> each.convertToGrid())
                .collect(Collectors.toList()),courseTransactions.getPageable(), courseTransactions.getTotalElements());

        return new ResponseEntity<>(transactionGridDTO, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Object> addCourseTransaction(@RequestBody UpsertCourseTransactionDTO dto)
    {
        courseTransactionService.saveCourseTransaction(dto);
        return new ResponseEntity<>("Data Transaction already added", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCourseTransaction(@RequestBody UpsertCourseTransactionDTO dto)
    {
        courseTransactionService.findById(dto.getId());
        courseTransactionService.updateCourseTransaction(dto);
        return new ResponseEntity<>("Data Successfully Updated", HttpStatus.OK);
    }
}
