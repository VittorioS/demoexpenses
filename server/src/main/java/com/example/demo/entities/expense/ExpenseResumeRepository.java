package com.example.demo.entities.expense;

import java.util.Date;

import com.example.demo.entities.expense.projections.ExpenseResumeProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RepositoryRestResource(excerptProjection = ExpenseResumeProjection.class)
public interface ExpenseResumeRepository extends JpaRepository<ExpenseResume, Date> {

        @Query(value = "SELECT NEW ExpenseResume(DAYOFWEEK(e.date), SUM(e.amount)) FROM Expense AS e GROUP BY DAYOFWEEK(e.date) ORDER BY DAYOFWEEK(e.date) ASC")
        @Override
        Page<ExpenseResume> findAll(Pageable pageable);

        @Query(value = "SELECT NEW ExpenseResume(DAYOFWEEK(e.date), SUM(e.amount)) FROM Expense AS e WHERE e.date between :dateStart and :dateEnd GROUP BY DAYOFWEEK(e.date) ORDER BY DAYOFWEEK(e.date) ASC")
        Page<ExpenseResume> findAllByDateBetween(
                        @Param(value = "dateStart") @DateTimeFormat(iso = ISO.DATE) Date dateStart,
                        @Param(value = "dateEnd") @DateTimeFormat(iso = ISO.DATE) Date dateEnd,
                        Pageable pageable);

}
