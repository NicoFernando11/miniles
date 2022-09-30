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
public class UpsertCourseTransactionDTO {

    private Long id;
    private Boolean isPending;
    private Boolean isExpired;
    private Boolean isConfirmed;
    private Long studentId;
    private Long tutorId;
    private Long courseId;


}
