package com.MiniLes.dto.student;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class StudentGridDTO {

    private Long id;

    private String name;

    private String gender;

    private String address;

    private LocalDate birthDate;

    private String hobby;


}
