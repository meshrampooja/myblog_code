package com.myblog.service;

import com.myblog.entities.Comment;
import com.myblog.entities.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post createPost(Post post);

    Post updatePost(Long id, Post post);

    void deletePost(Long id);


    List<Comment> getCommentsForPost(Long postId);

    Comment addCommentToPost(Long postId, Comment comment);
}

