package com.example.demo.repository;


import com.example.demo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {


    public List<Post> findAll();

    public Optional<Post> findById(long id);

    public List<Post> findAllByTitle(String title);

    public Optional<Post> findByTitle(String title);

    @Query(value = "SELECT * FROM POST WHERE AUTHOR = :author", nativeQuery = true)
    public List<Post> findByAuthor(@Param("author") String author);

    public void deleteById(long id);


//    @Query("select p from Post p where p.author = :author")
//    List<Post> findByAuthor(@Param("author") String author);

//    @Query(value = "SELECT e FROM Post e WHERE e.author like %:author%")
//    public List<Post> findByAuthorx(String author);
}
