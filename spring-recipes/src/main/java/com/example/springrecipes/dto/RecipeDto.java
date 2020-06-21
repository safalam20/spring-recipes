package com.example.springrecipes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDto {
    private Long id;
    private String name;
    private String picUrl;
    private String prepTime;
    private String cookTime;
    private String servings;
    private String calories;
    private String ingredients;
    private String directions;
    private Long categoryId;

}
