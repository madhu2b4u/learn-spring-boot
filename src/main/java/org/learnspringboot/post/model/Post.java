package org.learnspringboot.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.learnspringboot.users.model.User;

@Entity
public class Post {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue
    private int id;
    @Size(min = 5, message = "Description should have at least should have at least 5 characters")
    private String description;
    private String timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Post [id=" + id + ", description=" + description + ", timestamp=" + timestamp + "]";
    }

    public Post() {
    }

    public Post(int id, String description, String timestamp) {
        this.id = id;
        this.description = description;
        this.timestamp = timestamp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
