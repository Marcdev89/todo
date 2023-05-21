package com.omc.todo.service;

import com.omc.todo.entity.Todo;
import com.omc.todo.repository.TodoRepository;
import org.apache.logging.log4j.message.Message;
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

    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }
/*
    public List<Todo> findByTitle(String title) {
        return todoRepository.findAllByTitle(title);
    } */

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> findByUserId(Long user_id) {
        return todoRepository.findByUser(user_id);
    }

    public void validateData(String data){
        if (data.isEmpty()){
            throw new IllegalArgumentException("The title field is required. It can't be null.");
        }
        if (data.length() > 199){
            throw new IllegalArgumentException("The title length has to be more minor than 200 characters");
        }
    }

    public Todo save(Todo todo) {
        validateData(todo.getTitle());
            return todoRepository.save(todo);
    }

    public Todo updateTask(Todo todo, Long id) {
        Todo modifiedTodo = todoRepository.getReferenceById(id);
        modifiedTodo.setTitle(todo.getTitle());
        modifiedTodo.setCompleted(todo.isCompleted());
        return save(modifiedTodo);
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    public Page<Todo> listAll(int pageNumber, String sortField, String order, String keywordTitle, String keywordUsername) {
        int pageSize= 10;
        Sort sort = Sort.by(sortField);
        sort = order.equals("asc") ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);

        if (!keywordUsername.isEmpty()) {
            return todoRepository.findByUserNameAndTitle(keywordUsername,keywordTitle,pageable);
        }
        return todoRepository.findAll(keywordTitle,pageable);

    }
}
