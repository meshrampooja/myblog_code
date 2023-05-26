package com.myblog.service.Impl;

import com.myblog.entities.Comment;
import com.myblog.exception.CommentNotFoundException;
import com.myblog.repository.CommentRepository;
import com.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            return comment.get();
        } else {
            throw new CommentNotFoundException("Comment not found with id: " + id);
        }
    }

    @Override
    public Comment createComment(long postId,Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        Optional<Comment> existingComment = commentRepository.findById(id);
        if(existingComment.isPresent()) {
            Comment updatedComment = existingComment.get();
            updatedComment.setName(comment.getName());
            updatedComment.setEmail(comment.getEmail());
            updatedComment.setBody(comment.getBody());
            return commentRepository.save(updatedComment);
        } else {
            throw new CommentNotFoundException("Comment not found with id: " + id);
        }
    }

    @Override
    public void deleteComment(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            commentRepository.delete(comment.get());
        } else {
            throw new CommentNotFoundException("Comment not found with id: " + id);
        }
    }
}

