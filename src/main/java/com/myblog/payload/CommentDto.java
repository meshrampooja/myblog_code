package com.myblog.payload;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String text;
    private Long postId;

    // getters and setters
}

