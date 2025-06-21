package com.budget.app.services.implementation;

import com.budget.app.dto.ExpenseDTO;
import com.budget.app.entity.Category;
import com.budget.app.entity.Expense;
import com.budget.app.entity.User;
import com.budget.app.repository.CategoryRepository;
import com.budget.app.repository.ExpenseRepository;
import com.budget.app.repository.UserRepository;
import com.budget.app.services.IExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService implements IExpensesService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public void saveExpense(ExpenseDTO expenseDTO) throws Exception {
        Expense expense = new Expense();
        Optional<User> user = this.userRepository.findById(expenseDTO.getUserId());
        Optional<Category> category = this.categoryRepository.findById(expenseDTO.getCategoryId());

        if(user.isEmpty()) throw new Exception("No user");
        if(category.isEmpty()) throw new Exception("No Categ");

        expense.setUser(user.get());
        expense.setCategory(category.get());
        expense.setValue(expenseDTO.getValue());
        this.expenseRepository.save(expense);

    }

    @Override
    public List<Expense> findAll() {
        return this.expenseRepository.findAll();
    }
}
