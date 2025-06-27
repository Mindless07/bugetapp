package com.budget.app.repository;

import com.budget.app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> getCategoryByIdAndUserId(long categoryId, long userId);

    List<Category> findAllByUserId(long userId);

    Optional<Category> findByIdAndUserId(long categoryId, long userId);
}
