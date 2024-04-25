package com.example.PersonalFinanceManagement.management.model;

import com.example.PersonalFinanceManagement.management.Management;
import com.example.PersonalFinanceManagement.management.model.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DataManagementList(
        @PositiveOrZero
        BigDecimal value,
        Category category,
        @PastOrPresent
        LocalDate date
) {
    public DataManagementList(Management management){
        this(management.getValue(),management.getCategory(),management.getDate());
    }
}
