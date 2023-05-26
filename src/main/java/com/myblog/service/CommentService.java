package com.myblog.service;

import com.myblog.entities.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    Comment createComment(long postId,Comment comment);

    Comment updateComment(Long id, Comment comment);

    void deleteComment(Long id);
}

