package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin("*")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    @PostMapping
    public Expense add(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        expenseRepository.deleteById(id);
    }
}
