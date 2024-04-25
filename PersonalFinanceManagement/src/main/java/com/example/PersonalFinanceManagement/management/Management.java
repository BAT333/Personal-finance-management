package com.example.PersonalFinanceManagement.management;

import com.example.PersonalFinanceManagement.management.model.Category;
import com.example.PersonalFinanceManagement.management.model.DataManagement;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tbgerenciamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor")
    private BigDecimal value;
    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "data")
    private LocalDate date;
    @Column(name = "descricao")
    private String description;
    @Column(name = "ativo")
    private boolean active;

    public Management(DataManagement data) {
        this.active = true;
        this.value = data.value();
        this.category = data.category();
        this.description = data.description();
        if(data.date() != null){
            this.date = data.date();
        }else {
            this.date = LocalDate.now();
        }
    }
}
