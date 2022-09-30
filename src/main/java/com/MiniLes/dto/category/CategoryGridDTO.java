package com.MiniLes.dto.category;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class CategoryGridDTO {

    private Long id;


    private String name;


    private String description;
}
