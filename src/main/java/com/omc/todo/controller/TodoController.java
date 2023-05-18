package com.omc.todo.controller;

import com.omc.todo.entity.Todo;

import com.omc.todo.entity.User;
import com.omc.todo.service.TodoService;
import com.omc.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private UserService userService;
    @GetMapping
    public List<Todo> findAll(){
        return todoService.getTodoList();
    }
    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id){
        return todoService.getTodoById(id);
    }
    @GetMapping("/user/{user}")
    public List<Todo> findByUser(@PathVariable("user_id") Long user_id){
        return  todoService.findByUserId(user_id);

    }
    @PostMapping("/save")
    public Todo create(@RequestBody Todo todo){
        User user = userService.getUserById(todo.getUser().getId());
        todo.setUser(user);
        return  todoService.save(todo);
    }
    @PutMapping("/{id}")
    public Todo update(@RequestBody Todo todo, @PathVariable Long id){
        return todoService.updateTask(todo, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        todoService.deleteById(id);
    }

    @GetMapping("/todolist")
    public String todoList(Model model){
        model.addAttribute("todo", todoService.getTodoList());
        return "todo";
    }
}
