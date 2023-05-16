package com.omc.todo.repository;

import com.omc.todo.entity.Todo;
import com.omc.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

   List<Todo> findByUser(User user);
}
