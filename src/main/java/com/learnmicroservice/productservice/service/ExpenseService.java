package com.learnmicroservice.productservice.service;


import com.learnmicroservice.productservice.model.Expense;
import com.learnmicroservice.productservice.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;


    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    };

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository
                .findById(expense.getId())
                .orElseThrow(() -> new RuntimeException("Did not find any expense with given id: " + expense.getId()));

        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());

        expenseRepository.save(expense);
    };

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    };

    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException("Cannot find Expense by Name : " +  name));
    };

    public void deleteExpense(String id){
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("No such expense with id : " + id));
        expenseRepository.delete(expense);
    };
}
