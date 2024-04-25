package com.example.PersonalFinanceManagement.management.repository;

import com.example.PersonalFinanceManagement.management.Management;
import com.example.PersonalFinanceManagement.management.model.EarningsMonth;
import com.example.PersonalFinanceManagement.management.model.Expense;
import com.example.PersonalFinanceManagement.management.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ManagementRepository extends JpaRepository<Management,Long> {

    @Query(value = "SELECT g.date as date,sum(g.value) as total FROM Management g where g.category = 'EXPENSE' group by g.date")
    List<Expense> EXPENSE();

    @Query(value = "SELECT g.date as date,sum(g.value) as total FROM Management g where g.category = 'INCOME' group by g.date")
    List<Income> INCOME();

    List<Management> findByValueGreaterThanEqual(BigDecimal value);

    @Query(value = "SELECT sum(valor) as total, date_format(data,'%Y-%m') as month FROM tbgerenciamento where date_format(data,'%Y-%m') = ?1 group by month", nativeQuery = true)
    List<EarningsMonth> findByDate(String data);
}
