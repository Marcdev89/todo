package com.omc.todo.service;

import com.omc.todo.entity.Address;
import com.omc.todo.entity.User;
import com.omc.todo.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;
    public User user2;
    public User user3;

    @BeforeAll
   public void setUp() {

        MockitoAnnotations.openMocks(this);

        Address address2 = new Address("Alpha Street","New York","09912","USA");
        user2 = new User("Charles","ch23","1234",address2);
        user2.setId(2);
        Address address3 = new Address("Beta Street","Chicago","09932","USA");
        user3 = new User("Smith","sm23","1234",address3);
        user3.setId(3);

    }
    @Test
    void testUserServiceNotNull() {
        assertNotNull(userService);
    }
    @DisplayName("Create a new user")
    @Test
    void testCreate() {
        // Given - new user is created
        User newUser = new User();
        newUser.setId(1);
        newUser.setName("Robert");
        newUser.setUsername("R7");
        newUser.setPassword("rob7");

        // When - method create is called
        userService.create(newUser);

        // Behaviour
        when(userService.create(newUser)).thenReturn(newUser);

        // Then - user is properly saved and method returns the new user
        assertEquals(newUser,userService.create(newUser));
        assertEquals(1, newUser.getId());

    }
    @DisplayName("Get a List of all users")
    @Test
    void TestGetUsers() {
        //Given - a more than 1 user is saved
        userService.create(user2);
        userService.create(user3);

        List<User> userList = new ArrayList<>();
        userList.add(user2);
        userList.add(user3);

        // Behaviour
        when(userService.getUsers()).thenReturn(userList);

        //When - method getUsers is called
        List <User> actualUserList = userService.getUsers();

        // Then - method return a list of users
        assertEquals(2,userList.size());
        assertNotNull(actualUserList);
        assertEquals(userList,actualUserList);
    }
}