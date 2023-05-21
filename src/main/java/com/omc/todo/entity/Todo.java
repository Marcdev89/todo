package com.omc.todo.entity;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Nonnull
    private String title;
    private boolean completed;
    @ManyToOne (cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;

    public Todo() {
    }
    public Todo(String title, boolean completed, User user) {
        this.title = title;
        this.completed = completed;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", user=" + user +
                '}';
    }
}
