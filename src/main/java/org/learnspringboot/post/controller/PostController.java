package org.learnspringboot.post.controller;

import jakarta.validation.Valid;
import org.learnspringboot.post.model.Post;
import org.learnspringboot.post.repository.PostRepository;
import org.learnspringboot.users.exception.UserNotFoundException;
import org.learnspringboot.users.model.User;
import org.learnspringboot.users.repository.UserRepository;
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
public class PostController {

    private final PostRepository repository;

    private final UserRepository userRepository;

    public PostController(PostRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/jpa/posts")
    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    @GetMapping(path = "/jpa/posts/{id}")
    public Post getPostById(@PathVariable int id) {
        Optional<Post> post = repository.findById(id);
        if (post.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        return post.get();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@Valid @PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        post.setUser(user.get());
        repository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/jpa/posts/{id}")
    public void deletePostById(@PathVariable int id) {
        Optional<Post> post = repository.findById(id);
        repository.delete(post.get());
    }

}
