package com.MiniLes.repository;

import com.MiniLes.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = """
    Select * from Student where FullName Like %:name%
    """,nativeQuery = true)
    List<Student> findByName(@Param("name") String name);
}