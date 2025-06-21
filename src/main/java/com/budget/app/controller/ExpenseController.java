package com.budget.app.controller;

import com.budget.app.dto.ExpenseDTO;
import com.budget.app.entity.Expense;
import com.budget.app.services.IExpensesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    IExpensesService expensesService;

    @GetMapping
    public List<Expense> getExpenses() {
        return this.expensesService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveExpense(@RequestBody ExpenseDTO expenseDTO) throws Exception {
        expensesService.saveExpense(expenseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
