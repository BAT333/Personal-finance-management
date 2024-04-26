package com.example.PersonalFinanceManagement.management.service;

import com.example.PersonalFinanceManagement.management.Management;
import com.example.PersonalFinanceManagement.management.model.*;
import com.example.PersonalFinanceManagement.management.repository.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ManagementService {
    @Autowired
    ManagementRepository repository;

    public ResponseEntity<DataManagement> registerMAnagement(DataManagement data) {
        repository.save(new Management(data));
        return ResponseEntity.ok().body(data);
    }

    public DataManagementInformation ManagementList(DataManagementList data){
        if(data.date() != null){
            LocalDate star = AdjustingTime.StartOfMonth(data.date());
            LocalDate end = AdjustingTime.EndOfMonth(data.date());
            List<DataManagementList> managementList =  repository.findByDateBetween(star,end).stream().map(DataManagementList::new).toList();
            List<Expense> expenseList =  repository.EXPENSEDATE(star,end);
            List<Income> incomeList = repository.INCOMEDATE(star,end);
            return new DataManagementInformation(managementList,incomeList,expenseList);
        }else if(data.value() != null){
            List<DataManagementList> managementList =  repository.findByValueGreaterThanEqual(data.value()).stream().map(DataManagementList::new).toList();
            List<Expense> expenseList =  repository.EXPENSEVALUES(data.value());
            List<Income> incomeList = repository.INCOMEVALUES(data.value());
            return new DataManagementInformation(managementList,incomeList,expenseList);
        }else if(data.category() != null){
            if(data.category().equals(Category.EXPENSE)){
                return new DataManagementInformation(null,null,repository.EXPENSE());
            }else{
                return new DataManagementInformation(null,repository.INCOME(),null);
            }
        }else{
            List<DataManagementList> managementList =  repository.findAll().stream().map(DataManagementList::new).toList();
            return new DataManagementInformation(managementList,null,null);
        }
    }

    public List<CategoryYear> ManagementListYear(DataManagementList data) {
        if(data.date()!=null&&data.category() !=null){
            return repository.EXPENSEDATEYEARCATEGORY(data.date().getYear(),data.category());
        }else if(data.date() !=null){
            return repository.EXPENSEDATEYEAR(data.date().getYear());
        }else{
            return repository.EXPENSEDATEYEARALL();
        }
    }

    public List<CategoryMonth> ManagementListMonth(DataManagementList data) {
        if(data.date()!=null&&data.category() !=null){
            String datas = AdjustingTime.FormattingDate(data.date());
            return repository.EXPENSEDATEMONTHCATEGORY(datas,data.category());
        }else if(data.date() !=null){
            String datas = AdjustingTime.FormattingDate(data.date());
            return repository.EXPENSEDATEMONTH(datas);
        }else{
            return repository.EXPENSEDATEMONTHALL();
        }
    }

    }

