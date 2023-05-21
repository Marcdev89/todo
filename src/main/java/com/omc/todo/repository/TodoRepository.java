package com.omc.todo.repository;

import com.omc.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

   List<Todo> findByUser(Long user_id);

   @Query("SELECT t FROM Todo t WHERE t.title LIKE %?1%")
   Page <Todo> findAll(String keyword, Pageable pageable);

   @Query("SELECT t FROM Todo t WHERE (t.user.username = :username) AND (t.title LIKE %:title%)")
   Page <Todo> findByUserNameAndTitle(@Param("username") String keywordUsername, @Param("title") String keywordTitle, Pageable pageable);

}
