package com.MiniLes.dto.course;

import com.MiniLes.entity.Course;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class UpsertCourseDTO {
    private Long id;

    private String name;

    private Integer studyDuration;

    private Boolean isAvaiable;

    private Boolean isOnProgress;

    private String description;

    private BigDecimal price;


    private Long categoryId;

    public Course convertToEntity()
    {
        return Course.builder()
                .id(this.id)
                .name(this.name)
                .studyDuration(this.studyDuration)
                .isAvaiable(this.isAvaiable)
                .isOnProgress(this.isOnProgress)
                .description(this.description)
                .price(this.price)
                .categoryId(this.categoryId)
                .build();
    }

}
