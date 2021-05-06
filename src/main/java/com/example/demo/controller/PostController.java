package com.example.demo.controller;


import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import com.example.demo.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;


    @Autowired
    Test test;

    @GetMapping
    public List<Post> getAll(){
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable long id){
        return postService.getById(id);
    }

    @PostMapping
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    public void deleteSample(@PathVariable long id){
        postService.deletePost(id);
    }

    @PostMapping("/author")
    public List<Post> findByAuthor(@RequestBody String author){
        System.out.println(author);
        return postService.findByAuthor(author);
    }

    @PostMapping("/persist")
    public void insertToContext(@RequestBody  Post post){
        test.insertToContext(post);
    }

    @GetMapping("/remove/{id}")
    public void removeFromContext(@PathVariable long id){
        test.removeFromContext(id);
    }

    @PostMapping("/detach/{id}")
    public void detachFromContext(@PathVariable long id){
        test.detachFromContext(id);
    }

    @PostMapping("/check/{id}")
    public Post check(@PathVariable long id){
        return test.getSession( id);
    }

    @GetMapping("/change/{id}")
    public void changePersisted(@PathVariable long id){
        test.changeToTran( id);
    }

    @PostMapping("/title")
    public List<Post> title(@RequestBody String title){
        return postRepository.findAllByTitle(title);
    }

    @GetMapping("/detachAndMerge/{id}")
    public void detachAndMerge(@PathVariable long id){
         test.detachAndMerge(id);
    }










}
