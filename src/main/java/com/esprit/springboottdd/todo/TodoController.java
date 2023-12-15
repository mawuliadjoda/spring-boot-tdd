package com.esprit.springboottdd.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    String sayHello() {
        return "Hello World";
    }

    @GetMapping("/api/todos")
    List<Todo> findAll() {
        return todoRepository.findAll();
    }
}
