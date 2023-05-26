package com.myblog.controller;

import com.myblog.entities.Comment;
import com.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments()
    {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {

        return commentService.getCommentById(id);
    }

    //http://localhost:8080/api/posts/1/comments


    @PostMapping("/posts/{postId}")
    public Comment createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return commentService.createComment(postId, comment);
    }


    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {

        commentService.deleteComment(id);
    }
}

