package com.omc.todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 1,max = 199,message = "Title can not be longer than 199 characters")
    @NotNull
    private String title;
    private boolean completed;
    @ManyToOne (cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;

    public Todo(String title, boolean completed, User user) {
        this.title = title;
        this.completed = completed;
        this.user = user;
    }

}
