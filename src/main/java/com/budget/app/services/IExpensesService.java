package com.budget.app.services;

import com.budget.app.dto.ExpenseDTO;

import java.util.List;

public interface IExpensesService {
    void saveExpense(ExpenseDTO expenseDTO) throws Exception;

    List<ExpenseDTO> findAll() throws Exception;
}
