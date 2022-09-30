package com.MiniLes.repository;

import com.MiniLes.dto.courseTransaction.CourseTransactionGridDTO;
import com.MiniLes.entity.CourseTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseTransactionRepository extends JpaRepository<CourseTransaction, Long> {
    @Query(value = """
            Select * from CourseTransaction
            """,nativeQuery = true)
    Page<CourseTransaction> findAllByPage(Pageable pageable);
}