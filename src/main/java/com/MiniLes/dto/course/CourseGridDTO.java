package com.MiniLes.dto.course;

import com.MiniLes.entity.Category;
import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class CourseGridDTO {

    private Long id;

    private String name;

    private Integer studyDuration;

    private Boolean isAvaiable;

    private Boolean isOnProgress;

    private String description;

    private BigDecimal price;

    private Long categoryId;

    private Category category;



}
