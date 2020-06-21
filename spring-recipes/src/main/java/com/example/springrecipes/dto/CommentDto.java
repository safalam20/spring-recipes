package com.example.springrecipes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    private String content;
    private String username;
    private String createdAt;
}
