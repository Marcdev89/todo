package com.omc.todo.controller;

import com.omc.todo.entity.User;
import com.omc.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<User> getUsers (){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userRepository.getReferenceById(id);
    }
    @PostMapping
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }


}
