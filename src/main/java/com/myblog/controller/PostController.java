package com.myblog.controller;

import com.myblog.entities.Comment;
import com.myblog.entities.Post;
import com.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    //http://localhost:8080/api/posts


    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @GetMapping("/{postId}/comments")
    public List<Comment> getCommentsForPost(@PathVariable Long postId) {
        return postService.getCommentsForPost(postId);
    }

    @PostMapping("/{postId}/comments")
    public Comment addCommentToPost(@PathVariable Long postId, @RequestBody Comment comment) {
        return postService.addCommentToPost(postId, comment);
    }
}
