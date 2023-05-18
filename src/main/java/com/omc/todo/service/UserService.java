package com.omc.todo.service;

import com.omc.todo.entity.User;
import com.omc.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }
    public User create(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}
