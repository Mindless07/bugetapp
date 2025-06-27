package com.budget.app.services.implementation;

import com.budget.app.dto.ExpenseDTO;
import com.budget.app.entity.Category;
import com.budget.app.entity.Expense;
import com.budget.app.entity.User;
import com.budget.app.repository.CategoryRepository;
import com.budget.app.repository.ExpenseRepository;
import com.budget.app.services.IExpensesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpensesService implements IExpensesService {
    private final CategoryRepository categoryRepository;
    private final ExpenseRepository expenseRepository;
    private final UserService userService;

    @Override
    public void saveExpense(ExpenseDTO expenseDTO) throws Exception {
        Expense expense = new Expense();
        User user = this.userService.getCurrentUser();
        Optional<Category> category = this.categoryRepository.findById(expenseDTO.getCategoryId());

        if(category.isEmpty()) throw new Exception("No Categ");

        expense.setUser(user);
        expense.setCategory(category.get());
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
