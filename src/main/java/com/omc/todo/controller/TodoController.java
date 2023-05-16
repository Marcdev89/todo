package com.omc.todo.controller;

import com.omc.todo.entity.Todo;
import com.omc.todo.entity.User;
import com.omc.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @GetMapping
    public List<Todo> findAll(){
        return todoRepository.findAll();
    }
    @GetMapping("/user/{user}")
    public List<Todo> findByUser(User user){
        return  todoRepository.findByUser(user);

    }
    @PostMapping
    public Todo create(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }
    @PutMapping("/{id}")
    public Todo update(@RequestBody Todo todo, @PathVariable Long id){
        Todo modifiedTodo = todoRepository.getReferenceById(id);
            modifiedTodo.setTitle(todo.getTitle());
            modifiedTodo.setCompleted(todo.isCompleted());
            modifiedTodo.setUser(todo.getUser());

        return todoRepository.save(modifiedTodo);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        todoRepository.deleteById(id);
    }
}
