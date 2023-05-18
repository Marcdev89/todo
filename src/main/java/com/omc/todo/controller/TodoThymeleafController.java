package com.omc.todo.controller;

import com.omc.todo.entity.Todo;
import com.omc.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class TodoThymeleafController {
    @Autowired
    private TodoService todoService;
    @GetMapping({"/todo","/"})
    public String todoList(Model model){
        model.addAttribute("todo", todoService.getTodoList());
        return "sorted";
    }
    @GetMapping("/todo/pages/{pageNumber}/{field}/{order}")
    public ModelAndView sortedList(@PathVariable("pageNumber") int pageNumber, @PathVariable("field") String field, @PathVariable("order") String order){
        ModelAndView mav = new ModelAndView("sorted");
        int size = 10;
        Page<Todo> page = todoService.getTodoListPages(pageNumber,size, field,order);
        List<Todo> todoList = page.getContent();

        mav.addObject("pageNumber", pageNumber);
        mav.addObject("totalPages",page.getTotalPages());
        mav.addObject("Elements", page.getTotalElements());
        mav.addObject("todoList", todoList);
        mav.addObject("field", field);
        mav.addObject("order", order.equals("asc") ? "asc" : "desc");



        return mav;

    }
}
