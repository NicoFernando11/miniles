package com.MiniLes.entity;

import com.MiniLes.dto.courseTransaction.CourseTransactionGridDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CourseTransaction")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class CourseTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Bill")
    private BigDecimal bill;

    @Column(name = "IsPending")
    private Boolean isPending;

    @Column(name = "IsExpired")
    private Boolean isExpired;

    @Column(name = "IsConfirmed")
    private Boolean isConfirmed;

    @Column(name = "StudentId")
    private Long studentId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "StudentId", insertable = false, updatable = false)
    private Student student;

    @Column(name = "TutorId")
    private Long tutorId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "TutorId", insertable = false, updatable = false)
    private Tutor tutor;

    @Column(name = "CourseId")
    private Long courseId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CourseId", insertable = false, updatable = false)
    private Course course;

    public CourseTransaction(BigDecimal bill, Boolean isPending, Boolean isExpired, Boolean isConfirmed, Long studentId, Long tutorId, Long courseId) {
        this.bill = bill;
        this.isPending = isPending;
        this.isExpired = isExpired;
        this.isConfirmed = isConfirmed;
        this.studentId = studentId;
        this.tutorId = tutorId;
        this.courseId = courseId;
    }

    public CourseTransactionGridDTO convertToGrid()
    {
        return CourseTransactionGridDTO.builder()
                .id(this.id)
                .bill(this.bill)
                .isPending(this.isPending)
                .isExpired(this.isExpired)
                .isConfirmed(this.isConfirmed)
                .studentId(this.studentId)
                .student(this.student)
                .tutorId(this.tutorId)
                .tutor(this.tutor)
                .courseId(this.courseId)
                .course(this.course)
                .build();
    }


}
