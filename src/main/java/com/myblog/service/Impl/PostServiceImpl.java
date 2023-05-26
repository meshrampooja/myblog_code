package com.myblog.service.Impl;

import com.myblog.entities.Comment;
import com.myblog.entities.Post;
import com.myblog.exception.PostNotFoundException;
import com.myblog.repository.CommentRepository;
import com.myblog.repository.PostRepository;
import com.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            return post.get();
        } else {
            throw new PostNotFoundException("Post not found with id: " + id);
        }
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Optional<Post> existingPost = postRepository.findById(id);
        if(existingPost.isPresent()) {
            Post updatedPost = existingPost.get();
            updatedPost.setTitle(post.getTitle());
            updatedPost.setDescription(post.getDescription());
            updatedPost.setContent(post.getContent());
            return postRepository.save(updatedPost);
        } else {
            throw new PostNotFoundException("Post not found with id: " + id);
        }
    }

    @Override
    public void deletePost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            postRepository.delete(post.get());
        } else {
            throw new PostNotFoundException("Post not found with id: " + id);
        }
    }

    @Override
    public List<Comment> getCommentsForPost(Long postId) {
        Post post = getPostById(postId);
        return commentRepository.findByPost(post);
    }

    @Override
    public Comment addCommentToPost(Long postId, Comment comment) {
        Post post = getPostById(postId);
        comment.setPost(post);
        return commentRepository.save(comment);
    }



}

