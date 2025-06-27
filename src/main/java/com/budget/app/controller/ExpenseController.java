package com.budget.app.controller;

import com.budget.app.dto.ExpenseDTO;
import com.budget.app.services.IExpensesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@AllArgsConstructor
public class ExpenseController {
    private final IExpensesService expensesService;

    @GetMapping
    public List<ExpenseDTO> getExpenses() throws Exception {
        return this.expensesService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveExpense(@RequestBody ExpenseDTO expenseDTO) throws Exception {
        expensesService.saveExpense(expenseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
