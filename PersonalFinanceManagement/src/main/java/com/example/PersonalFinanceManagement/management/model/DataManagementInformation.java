package com.example.PersonalFinanceManagement.management.model;

import java.util.List;
import java.util.Optional;

public record DataManagementInformation(
        List<DataManagementList> dataManagement,
        List<Income> income,
        List<Expense> expense) {
}
