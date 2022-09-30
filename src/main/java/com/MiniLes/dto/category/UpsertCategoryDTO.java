package com.MiniLes.dto.category;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UpsertCategoryDTO {

    private Long id;


    private String name;


    private String description;
}
