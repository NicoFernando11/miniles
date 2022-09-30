package com.MiniLes.entity;

import com.MiniLes.dto.category.CategoryGridDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryGridDTO convertToGrid()
    {
        return CategoryGridDTO.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .build();
    }
}
