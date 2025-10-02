package com.mika.demo.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("John Doe");
        model.addAttribute("todos", todos);
        return "todos";
    }

    @RequestMapping("add-todo")
    public String showTodo(ModelMap model) {
        String username = (String) model.get("name");
        LocalDate startDate = LocalDate.now().plusYears(1);
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

        String description = todo.getDescription();
        String username = (String) model.get("name");
        LocalDate startDate = LocalDate.now().plusYears(1);
        boolean status = false;

        todoService.add(username, description, startDate, status);

        return "redirect:todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:todos";
    }
}
