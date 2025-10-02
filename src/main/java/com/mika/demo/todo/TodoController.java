package com.mika.demo.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

// @Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    @RequestMapping("todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername(model);

        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos", todos);
        return "todos";
    }

    @RequestMapping("add-todo")
    public String showTodoPage(ModelMap model) {
        String username = getLoggedInUsername(model);
        LocalDate startDate = null;
        boolean status = false;
        Todo todo = new Todo(0, username, "", startDate, status);
        model.put("todo", todo);

        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid @ModelAttribute Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        String username = getLoggedInUsername(model);
        String description = todo.getDescription();
        LocalDate startDate = todo.getStartDate();
        boolean status = todo.getStatus();

        todoService.add(username, description, startDate, status);

        return "redirect:todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        // find by id
        Todo todo = todoService.findById(id);

        // add values to modal
        model.put("todo", todo);

        return "update-todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "update-todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);

        todoService.updateTodo(todo);

        return "redirect:todos";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
