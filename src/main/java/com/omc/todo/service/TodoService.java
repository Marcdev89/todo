package com.omc.todo.service;

import com.omc.todo.entity.Todo;
import com.omc.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getTodoList(){
        return todoRepository.findAll();
    }
    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> findByUserId(Long user_id){
        return todoRepository.findByUser(user_id);
    }

    public Todo save(Todo todo){
        return  todoRepository.save(todo);
    }

    public Todo updateTask(Todo todo, Long id){
        Todo modifiedTodo = todoRepository.getReferenceById(id);
        modifiedTodo.setTitle(todo.getTitle());
        modifiedTodo.setCompleted(todo.isCompleted());
        return todoRepository.save(modifiedTodo);
    }

    public void deleteById(Long id){
        todoRepository.deleteById(id);
    }

    public Page<Todo> getTodoListPages(int pageNum, int pageSize, String field, String order){
        Pageable pageable = PageRequest.of(pageNum -1, pageSize, order.equals("asc") ? Sort.by(field).ascending() :
                Sort.by(field).descending());
        return todoRepository.findAll(pageable);
    }



}
