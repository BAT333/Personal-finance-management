package com.example.PersonalFinanceManagement.management.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DataManagement(
         @NotNull
         @PositiveOrZero
         BigDecimal value,
         @NotNull
         Category category,
         @PastOrPresent
         LocalDate date,
         @NotNull
         String description


) {
}
