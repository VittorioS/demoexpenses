package com.example.demo.entities.expense;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

        Expense findByCategory(@Param(value = "category") String category);

        Page<Expense> findAllByCategory(@Param(value = "category") String category, Pageable pageable);

        Page<Expense> findAllByDate(@Param(value = "date") @DateTimeFormat(iso = ISO.DATE) Date date,
                        Pageable pageable);

        Page<Expense> findAllByDateAndCategory(@Param(value = "date") @DateTimeFormat(iso = ISO.DATE) Date date,
                        @Param(value = "category") String category, Pageable pageable);

        Page<Expense> findAllByDateBetween(@Param(value = "dateStart") @DateTimeFormat(iso = ISO.DATE) Date dateStart,
                        @Param(value = "dateEnd") @DateTimeFormat(iso = ISO.DATE) Date dateEnd,
                        Pageable pageable);

        Page<Expense> findAllByDateBetweenAndCategory(
                        @Param(value = "dateStart") @DateTimeFormat(iso = ISO.DATE) Date dateStart,
                        @Param(value = "dateEnd") @DateTimeFormat(iso = ISO.DATE) Date dateEnd,
                        @Param(value = "category") String category, Pageable pageable);

        Page<Expense> findAllByDateBetweenOrCategory(
                        @Param(value = "dateStart") @DateTimeFormat(iso = ISO.DATE) Date dateStart,
                        @Param(value = "dateEnd") @DateTimeFormat(iso = ISO.DATE) Date dateEnd,
                        @Param(value = "category") String category, Pageable pageable);

}
