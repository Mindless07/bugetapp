package com.budget.app.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseDTO {    @Id
    private long categoryId;
    private long userId;
    private long value;

    @Override
    public String toString() {
        return "ExpenseDTO{" +
                "categoryId=" + categoryId +
                ", userId=" + userId +
                ", value=" + value +
                '}';
    }
}
