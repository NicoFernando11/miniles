package com.MiniLes.dto.student;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UpsertStudentDTO {

    private Long id;

    private String name;

    private String gender;

    private String address;

    private LocalDate birthDate;

    private String hobby;
}
