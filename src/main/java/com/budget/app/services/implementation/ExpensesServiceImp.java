package com.budget.app.services.implementation;

import com.budget.app.dto.ExpenseDTO;
import com.budget.app.entity.Category;
import com.budget.app.entity.Expense;
import com.budget.app.entity.User;
import com.budget.app.repository.ExpenseRepository;
import com.budget.app.services.ICategoryService;
import com.budget.app.services.IExpensesService;
import com.budget.app.services.IUsersService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpensesServiceImp implements IExpensesService {
    private final ICategoryService categoryService;
    private final ExpenseRepository expenseRepository;
    private final IUsersService userService;

    @Override
    public void saveExpense(ExpenseDTO expenseDTO) throws Exception {
        Expense expense = new Expense();
        User user = this.userService.getCurrentUser();
        Category category = this.categoryService.findByUserId(expenseDTO.getCategoryId(), user.getId());

        expense.setUser(user);
        expense.setCategory(category);
        expense.setValue(expenseDTO.getValue());
        this.expenseRepository.save(expense);

    }

    @Override
    public List<ExpenseDTO> findAll() throws Exception {
        User user = this.userService.getCurrentUser();
        List<ExpenseDTO> expenses = this.expenseRepository.findAllByUserId(user.getId()).stream().map(
                ExpenseDTO::new
        ).toList();;
        return expenses;
    }
}
