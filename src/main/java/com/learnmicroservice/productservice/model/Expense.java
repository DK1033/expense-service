package com.learnmicroservice.productservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;


@Document("expenses")
@Data
@NoArgsConstructor
public class Expense {

    @Id
    private String id;

    @Field(value = "name")
    @Indexed(unique = true)
    private String expenseName;

    @Field(value = "category")
    private ExpenseCategory expenseCategory;

    @Field(value = "amount")
    private BigDecimal expenseAmount;

}
