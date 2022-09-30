package com.MiniLes.dto.tutor;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UpsertTutorDTO {

    private Long id;


    private String name;

    private String gender;


    private String address;


    private LocalDate birthDate;


    private String hobby;


    private String email;

}
