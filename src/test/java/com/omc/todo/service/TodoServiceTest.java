package com.omc.todo.service;

import com.omc.todo.entity.Address;
import com.omc.todo.entity.Todo;
import com.omc.todo.entity.User;
import com.omc.todo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TodoServiceTest {

    @Autowired
    TodoService todoService;
    @Mock
    TodoRepository todoRepository;

    public User user1;
    public Todo todo1;
    public Todo todo2;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Address address1 = new Address("Alpha Street","New York","09912","USA");
        user1 = new User("Charles","ch23","1234",address1);
        user1.setId(1L);
        todo1 = new Todo("My first task",true,user1);
        todo1.setId(1L);
        todo2 = new Todo("My second task",false,user1);
        todo2.setId(2L);
    }
    @DisplayName("Get full list of todo")
    @Test
    void testGetTodoList() {
        //Given - a more than 1 to-do is saved
        todoService.save(todo1);
        todoService.save(todo2);

        List<Todo> todoList = new ArrayList<>();
        todoList.add(todo1);
        todoList.add(todo2);

        // Behaviour
        when(todoService.getTodoList()).thenReturn(todoList);

        //When - method getTodoList is called
        List <Todo> actualTodoList = todoService.getTodoList();

        // Then - method return a list of to-do
        assertEquals(2,actualTodoList.size());
        assertNotNull(actualTodoList);
        assertEquals(todoList,actualTodoList);
    }
    @DisplayName("Validate de correct data for title")
    @Test
    void testValidateData() {
        //Given - 3 different conditions: title length >=200, title = null and correct data
        String correctTitle = "Very important task";
        String longerTitle="";
        do {longerTitle += "x";
        }while (longerTitle.length()<201);
        IllegalArgumentException longer = new IllegalArgumentException("longer");
        IllegalArgumentException notNull = new IllegalArgumentException("not null");

        // Behaviour
      /*  doThrow(longer).when(todoService).validateData(longerTitle);
        doThrow(notNull).when(todoService).validateData(null);
        doNothing().when(todoService).validateData(correctTitle); */

        //When - method is called 3 different ways:

        //String length >199
           try{
               todoService.validateData(longerTitle);
               fail("Exception not throw");
           }catch (IllegalArgumentException e){
               // Then - method Throws
               assertNotNull(e);
               assertEquals("longer",e.getMessage());
           }
        // null
            try{
                todoService.validateData(null);
                fail("Exception not throw");
            }catch (IllegalArgumentException e){
                // Then - method Throws
                assertNotNull(e);
                assertEquals("not null",e.getMessage());
            }
        // String with correct data
            todoService.validateData(correctTitle);
        //verify if method is called
        assertEquals(3, Mockito.mockingDetails(todoService).getInvocations().size());
    }

    @Test
    void testSave() {
        // Given - new to-do is created
        Todo newTask = new Todo();
        newTask.setId(23);
        newTask.setCompleted(true);
        newTask.setUser(user1);

        // When - method create is called
        todoService.save(newTask);

        // Behaviour
        when(todoService.save(newTask)).thenReturn(newTask);

        // Then - user is properly saved and method returns the new user
        assertEquals(newTask,todoService.save(newTask));
        assertEquals(23, newTask.getId());
    }
    @DisplayName("Get a to-do task by todoID")
    @Test
    void TestGetTodoById(){
        //Given we have to-do tasks created
        todoService.save(todo1);
        Long todoId = todo1.getId();

        // Behaviour
        when(todoService.getTodoById(todoId)).thenReturn(todo1);

        // When method is called with correct id
        Todo actualTodo = todoService.getTodoById(todoId);

        // Then - we get the to-do
        assertEquals(todo1,actualTodo);

    }


    @DisplayName("Update a task (put) ")
    @Test
    void testUpdateTask() {
        // Given - we have a created to-do
        todoService.save(todo1);
        Long todoId = todo1.getId();
        Todo modifiedTask = new Todo("modified",true,user1);
        modifiedTask.setId(todoId);

        // Config behaviour of getTodoById
        when(todoService.getTodoById(todoId)).thenReturn(modifiedTask);
        //Behaviour
        when(todoService.updateTask(modifiedTask, todoId)).thenReturn(modifiedTask);

        //When method is called
        todoService.updateTask(modifiedTask, todoId);

        //Then - To-do is modified with new data
        assertEquals(modifiedTask, todoService.updateTask(modifiedTask,todoId));
        assertEquals(modifiedTask, todoService.getTodoById(todoId));

    }
}