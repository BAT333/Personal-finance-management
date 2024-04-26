package com.example.PersonalFinanceManagement.management.model;

import java.math.BigDecimal;

public interface CategoryMonth {
    Category getCategory();
    BigDecimal getTotal();
    String getMonth();
}
