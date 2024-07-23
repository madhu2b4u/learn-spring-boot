package org.learnspringboot.users.controller;

import jakarta.validation.Valid;
import org.learnspringboot.post.model.Post;
import org.learnspringboot.users.exception.UserNotFoundException;
import org.learnspringboot.users.model.User;
import org.learnspringboot.users.repository.UserRepository;
import org.learnspringboot.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController {

    private UserRepository repository;

    public UserJpaController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> getAllPostsByUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        return  user.get().getPosts();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        // implementing hateoas
        EntityModel<User> model = EntityModel.of(user.get());
        model.add(linkTo(methodOn(UserJpaController.class).getAllUsers()).withRel("all-users"));

        return model;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        repository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        repository.delete(user.get());
    }

}
