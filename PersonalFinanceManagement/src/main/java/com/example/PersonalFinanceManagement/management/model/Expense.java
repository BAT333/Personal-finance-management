package com.example.PersonalFinanceManagement.management.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Expense {
    LocalDate getDate();

    BigDecimal getTotal();
}
