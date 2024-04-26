package com.example.PersonalFinanceManagement.management.repository;

import com.example.PersonalFinanceManagement.management.Management;
import com.example.PersonalFinanceManagement.management.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ManagementRepository extends JpaRepository<Management,Long> {

    @Query(value = "SELECT g.date as date,sum(g.value) as total FROM Management g where g.category = 'EXPENSE' group by g.date")
    List<Expense> EXPENSE();
    @Query(value = "SELECT g.date as date,sum(g.value) as total FROM Management g where g.category = 'EXPENSE' AND g.value>= ?1 group by g.date")
    List<Expense> EXPENSEVALUES(BigDecimal values);
    @Query(value = "SELECT g.date as date,sum(g.value) as total FROM Management g where g.category = 'EXPENSE' and g.date between ?1 and ?2 group by g.date")
    List<Expense> EXPENSEDATE(LocalDate start, LocalDate end);
    @Query(value = "SELECT g.date as date,sum(g.value) as total FROM Management g where g.category = 'INCOME' group by g.date")
    List<Income> INCOME();
    @Query(value = "SELECT g.date as date,sum(g.value) as total FROM Management g where g.category = 'INCOME' AND g.value>= ?1 group by g.date")
    List<Income> INCOMEVALUES(BigDecimal values);
    @Query(value = "SELECT g.date as date,sum(g.value) as total FROM Management g where g.category = 'INCOME' and g.date between ?1 and ?2 group by g.date")
    List<Income> INCOMEDATE(LocalDate start, LocalDate end);

    List<Management> findByValueGreaterThanEqual(BigDecimal value);

    @Query(value = "SELECT sum(valor) as total, date_format(data,'%Y-%m') as month FROM tbgerenciamento where date_format(data,'%Y-%m') = ?1 group by month", nativeQuery = true)
    List<EarningsMonth> findByDate(String data);

    List<Management> findByDateBetween(LocalDate start, LocalDate end);

    @Query(value = "SELECT categoria as category , sum(valor) as total, year(data)  as year FROM tbgerenciamento where year(data) = ?1 group by categoria, year(data)", nativeQuery = true)
    List<CategoryYear> EXPENSEDATEYEAR(int year);

    @Query(value = "SELECT categoria as category , sum(valor) as total, year(data)  as year FROM tbgerenciamento where year(data) = ?1 AND categoria = ?2 group by categoria, year(data)", nativeQuery = true)
    List<CategoryYear> EXPENSEDATEYEARCATEGORY(int year, Category category);
    @Query(value = "SELECT categoria as category , sum(valor) as total, year(data)  as year FROM tbgerenciamento group by categoria, year(data)", nativeQuery = true)
    List<CategoryYear> EXPENSEDATEYEARALL();
    @Query(value = "SELECT sum(valor) as total, date_format(data,'%Y-%m') as month , categoria as category FROM tbgerenciamento group by month, categoria;",nativeQuery = true)
    List<CategoryMonth>  EXPENSEDATEMONTHALL();
    @Query(value = "SELECT categoria as category , sum(valor) as total,date_format(data,'%Y-%m') as month FROM tbgerenciamento where date_format(data,'%Y-%m')= ?1 AND categoria = ?2 group by categoria, date_format(data,'%Y-%m')", nativeQuery = true)
    List<CategoryMonth> EXPENSEDATEMONTHCATEGORY(String datas, Category category);
    @Query(value = "SELECT categoria as category , sum(valor) as total,date_format(data,'%Y-%m') as month FROM tbgerenciamento where date_format(data,'%Y-%m')= ?1 group by categoria, date_format(data,'%Y-%m')", nativeQuery = true)
    List<CategoryMonth> EXPENSEDATEMONTH(String datas);
}
