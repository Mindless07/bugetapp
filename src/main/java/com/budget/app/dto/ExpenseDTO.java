package com.budget.app.dto;

import com.budget.app.entity.Expense;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDTO {
    private long categoryId;
    private long value;

    public ExpenseDTO(Expense expenseEntity) {
        this.categoryId = expenseEntity.getId();
        this.value = expenseEntity.getValue();
    }
}
