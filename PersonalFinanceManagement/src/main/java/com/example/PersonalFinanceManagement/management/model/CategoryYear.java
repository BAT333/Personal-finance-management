package com.example.PersonalFinanceManagement.management.model;

import java.math.BigDecimal;

public interface CategoryYear {
    Category getCategory();
    BigDecimal getTotal();
    int getYear();

}
