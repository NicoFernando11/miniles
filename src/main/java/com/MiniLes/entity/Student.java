package com.MiniLes.entity;

import com.MiniLes.dto.student.StudentGridDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Student")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "FullName")
    private String name;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Address")
    private String address;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @Column(name = "Hobby")
    private String hobby;


    public Student(String name, String gender, String address, LocalDate birthDate, String hobby) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.hobby = hobby;
    }

    public StudentGridDTO convertToGrid()
    {
        return StudentGridDTO.builder()
                .id(this.id)
                .name(this.name)
                .gender(this.gender)
                .address(this.address)
                .birthDate(this.birthDate)
                .hobby(this.hobby)
                .build();
    }
}
