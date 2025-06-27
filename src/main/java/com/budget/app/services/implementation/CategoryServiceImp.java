package com.budget.app.services.implementation;

import com.budget.app.dto.CategoryDto;
import com.budget.app.entity.Category;
import com.budget.app.entity.User;
import com.budget.app.repository.CategoryRepository;
import com.budget.app.services.ICategoryService;
import com.budget.app.services.IUsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final IUsersService usersService;

    @Override
    public CategoryDto getCategoryOfUser(long categoryId, long userId) throws Exception {
        Optional<Category> category = categoryRepository.getCategoryByIdAndUserId(categoryId, userId);

        if(category.isEmpty()) throw new Exception(
                "no category ".concat(String.valueOf(categoryId)).concat(" for userId ".concat(String.valueOf(userId))));

        return new CategoryDto(category.get());
    }

    @Override
    public List<CategoryDto> findAll() throws Exception {
        User user = usersService.getCurrentUser();
        List<Category> categories = categoryRepository.findAllByUserId(user.getId());

        return categories.stream().map(CategoryDto::new).collect(Collectors.toList());
    }

    @Override
    public void save(CategoryDto category) throws Exception {
        User user = usersService.getCurrentUser();

        Category categorySave = new Category();
        categorySave.setLabel(category.getLabel());
        categorySave.setUser(user);

        categoryRepository.save(categorySave);
    }

    @Override
    public Category findByUserId(long categoryId, long userId) throws Exception {
        Optional<Category> category = this.categoryRepository.findByIdAndUserId(categoryId, userId);

        if(category.isEmpty()) throw new Exception("No category found");

        return category.get();
    }
}
