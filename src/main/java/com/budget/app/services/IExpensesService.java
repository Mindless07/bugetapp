package com.budget.app.services;

import com.budget.app.dto.ExpenseDTO;
import com.budget.app.entity.Expense;

import java.util.List;

public interface IExpensesService {
    void saveExpense(ExpenseDTO expenseDTO) throws Exception;

    List<Expense> findAll();
}
