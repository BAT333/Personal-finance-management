package com.example.PersonalFinanceManagement.management.service;

import com.example.PersonalFinanceManagement.management.Management;
import com.example.PersonalFinanceManagement.management.model.Category;
import com.example.PersonalFinanceManagement.management.model.DataManagementInformation;
import com.example.PersonalFinanceManagement.management.model.DataManagementList;
import com.example.PersonalFinanceManagement.management.model.DataManagement;
import com.example.PersonalFinanceManagement.management.repository.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class ManagementService {
    @Autowired
    ManagementRepository repository;

    public ResponseEntity<DataManagement> registerMAnagement(DataManagement data) {
        repository.save(new Management(data));
        return ResponseEntity.ok().body(data);
    }

    public <T> T ManagementList(DataManagementList dataManagementList) {
        List<DataManagementList> dataManagement = repository.findAll().stream().map(DataManagementList::new).toList();
        //return (T) new RelatorioGestao(transacoes, repository.DESPESA(), repository.RECEITA());
        if(Category.INCOME.equals(dataManagementList.category())){
            return (T)repository.INCOME();
        }else if(Category.EXPENSE.equals(dataManagementList.category())){
            return (T)repository.EXPENSE();
        }else if(dataManagementList.value() != null){
            return (T)repository.findByValueGreaterThanEqual(dataManagementList.value()).stream().map(DataManagementList::new).toList();
        }else if(dataManagementList.date()!= null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
            String data = dataManagementList.date().format(formatter);
            return (T)repository.findByDate(data);
        }{
            return (T)new DataManagementInformation(dataManagement,repository.INCOME(),repository.EXPENSE());
        }
    }
}
