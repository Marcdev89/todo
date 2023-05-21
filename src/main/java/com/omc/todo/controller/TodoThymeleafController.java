package com.omc.todo.controller;

import com.omc.todo.entity.Todo;
import com.omc.todo.entity.User;
import com.omc.todo.service.TodoService;
import com.omc.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class TodoThymeleafController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private UserService userService;

    @RequestMapping({"/home","/"})
    public String homePage(Model model) {
        return listByPage(model, 1,"title","asc", "","");
    }

    @GetMapping("/todo/new")
    public String formCreateTodo(Model model) {
        model.addAttribute("users", userService.getUsers());
        Todo todoPost = new Todo();
        model.addAttribute("todoPost", todoPost);
        return "create";
    }

    @PostMapping("/save")
    public String saveTodo(@ModelAttribute("todo") Todo todo){
        User user = userService.getUserById(todo.getUser().getId());
        todo.setUser(user);
        todoService.save(todo);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String updateTodo(@PathVariable Long id, Model model) {
        Todo modified = todoService.getTodoById(id);
        List<Todo> todoList = todoService.getTodoList();
        model.addAttribute("title","Form edit");
        model.addAttribute("completed","Form edit");
        model.addAttribute("modified", modified);
        model.addAttribute("todoList", todoList);
        return "create";
    }

    @PostMapping("/edited")
    public String editTodo(@ModelAttribute("todo") Todo todo){
             todoService.updateTask(todo, todo.getId());
        return "redirect:/home";
    }
    @GetMapping("/page/{pageNumber}")
    public String listByPage(Model model,
                             @PathVariable("pageNumber") int currentPage,
                             @Param("sortField") String sortField,
                             @Param("order") String order,
                             @Param("keywordTitle") String keywordTitle,
                             @Param("keywordUsername") String keywordUsername) {

        Page<Todo> page = todoService.listAll(currentPage,sortField,order,keywordTitle, keywordUsername);

        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        List<Todo> todoList = page.getContent();

        model.addAttribute("todoList", todoList);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("sortField",sortField);
        model.addAttribute("order", order);
        model.addAttribute("keywordTitle", keywordTitle);
        model.addAttribute("keywordUsername", keywordUsername);

        String reverseOrder = order.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseOrder", reverseOrder);
        return "home";
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        todoService.deleteById(id);
    }


}
