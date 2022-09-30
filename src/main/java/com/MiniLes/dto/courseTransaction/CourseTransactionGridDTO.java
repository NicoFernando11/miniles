package com.MiniLes.dto.courseTransaction;

import com.MiniLes.entity.Course;
import com.MiniLes.entity.Student;
import com.MiniLes.entity.Tutor;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class CourseTransactionGridDTO {

    private Long id;
    private BigDecimal bill;
    private Boolean isPending;
    private Boolean isExpired;
    private Boolean isConfirmed;
    private Long studentId;
    private Student student;
    private Long tutorId;
    private Tutor tutor;
    private Long courseId;
    private Course course;

}
