package com.MiniLes.entity;

import com.MiniLes.dto.course.CourseGridDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Course")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "CourseName")
    private String name;

    @Column(name = "StudyDuration")
    private Integer studyDuration;

    @Column(name = "IsAvaiable")
    private Boolean isAvaiable;

    @Column(name = "IsOnProgress")
    private Boolean isOnProgress;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private BigDecimal price;


    @Column(name = "CategoryId")
    private Long categoryId;


    @ManyToOne
    @JoinColumn(name = "CategoryId",insertable = false,updatable = false)
    private Category category;

    public Course(String name, Integer studyDuration, Boolean isAvaiable, Boolean isOnProgress, String description, BigDecimal price,Long categoryId) {
        this.name = name;
        this.studyDuration = studyDuration;
        this.isAvaiable = isAvaiable;
        this.isOnProgress = isOnProgress;
        this.description = description;
        this.price = price;

        this.categoryId = categoryId;
    }

    public CourseGridDTO convertToGrid()
    {
        return CourseGridDTO.builder()
                .id(this.id)
                .name(this.name)
                .studyDuration(this.studyDuration)
                .isAvaiable(this.isAvaiable)
                .isOnProgress(this.isOnProgress)
                .description(this.description)
                .price(this.price)
                .categoryId(this.categoryId)
                .category(this.category)
                .build();
    }

   }
