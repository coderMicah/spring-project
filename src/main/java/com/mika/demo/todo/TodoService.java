package com.mika.demo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();;
    private static int todoCount = 0;
    static {
        todos.add(new Todo(++todoCount, "John Doe", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "John Doe", "Learn Java", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "John Doe", "Learn Javascript", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void add(String username, String description, LocalDate startDate, boolean status) {
        Todo todo = new Todo(++todoCount, username, description, startDate, status);
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);

    }
}
