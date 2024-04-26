package com.example.PersonalFinanceManagement.management.controller;

import com.example.PersonalFinanceManagement.management.model.*;
import com.example.PersonalFinanceManagement.management.service.ManagementService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management")
public class ManagementController {
    @Autowired
    ManagementService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DataManagement> register(@RequestBody @Valid DataManagement data){
        return service.registerMAnagement(data);

    }
    @GetMapping
    public DataManagementInformation list(@RequestBody DataManagementList dataManagementList){
        return service.ManagementList(dataManagementList);
    }

    @GetMapping("/year")
    public List<CategoryYear> listCategoryYear(@RequestBody DataManagementList dataManagementList){
        return service.ManagementListYear(dataManagementList);
    }
    @GetMapping("/month")
    public List<CategoryMonth> listExpense(@RequestBody DataManagementList dataManagementList){
        return service.ManagementListMonth(dataManagementList);
    }





}
