package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }


    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable long id){
        return userRepository.findById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getById(@PathVariable long id){
        return userRepository.findPostsForUser(id);
    }

    @PostMapping("/name")   // What if I have two Dean's ???
    public User findByName(@RequestBody String name){
        return userRepository.findByName(name);
    }

    @GetMapping("/{id}/test")
    public String getIDAndName(@PathVariable long id){
        return userRepository.getIDAndName(id);
    }

    @GetMapping("/morePosts")
    public List<Post> findMoreThanOnce(){
        return userRepository.findMoreThanOnce();
    }


}
