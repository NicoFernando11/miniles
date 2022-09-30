package com.MiniLes.repository;

import com.MiniLes.entity.Student;
import com.MiniLes.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    @Query(value = """
            Select * from Tutor where FullName Like %:name%
            """, nativeQuery = true)
    List<Tutor> findByName(@Param("name") String name);
}