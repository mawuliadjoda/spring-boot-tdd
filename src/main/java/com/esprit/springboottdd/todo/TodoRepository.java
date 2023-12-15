package com.esprit.springboottdd.todo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {
    List<Todo> todos;
    private TodoRepository() {
        this.todos = List.of(
                new Todo("Test 1", true),
                new Todo("Test 2", true)
        );
    }
    public List<Todo> findAll() {
        return this.todos;
    }
}
