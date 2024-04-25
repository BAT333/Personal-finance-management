package com.example.PersonalFinanceManagement.management.controller;

import com.example.PersonalFinanceManagement.management.model.DataManagement;
import com.example.PersonalFinanceManagement.management.model.DataManagementList;
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
    public <T> T list(@RequestBody DataManagementList dataManagementList){
        return service.ManagementList(dataManagementList);
    }



}
