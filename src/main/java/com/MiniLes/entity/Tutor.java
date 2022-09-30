package com.MiniLes.entity;

import com.MiniLes.dto.student.StudentGridDTO;
import com.MiniLes.dto.tutor.TutorGridDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Tutor")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Tutor {

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

    @Column(name = "Email")
    private String email;

    public Tutor(String name, String gender, String address, LocalDate birthDate, String hobby, String email) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.hobby = hobby;
        this.email = email;
    }

    public TutorGridDTO convertToGrid()
    {
        return TutorGridDTO.builder()
                .id(this.id)
                .name(this.name)
                .gender(this.gender)
                .address(this.address)
                .birthDate(this.birthDate)
                .hobby(this.hobby)
                .email(this.email)
                .build();
    }


}
