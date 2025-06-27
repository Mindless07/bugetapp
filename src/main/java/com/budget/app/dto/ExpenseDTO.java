package com.budget.app.dto;

import com.budget.app.entity.Expense;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExpenseDTO {
    @Id
    private long categoryId;
    private long value;

    public ExpenseDTO(Expense expenseEntity) {
        this.categoryId = expenseEntity.getId();
        this.value = expenseEntity.getValue();
    }
}
