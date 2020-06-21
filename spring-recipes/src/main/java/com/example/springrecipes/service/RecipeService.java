package com.example.springrecipes.service;

import com.example.springrecipes.dto.RecipeDto;
import com.example.springrecipes.model.Category;
import com.example.springrecipes.model.Recipe;
import com.example.springrecipes.model.User;
import com.example.springrecipes.repository.CategoryRepository;
import com.example.springrecipes.repository.RecipeRepository;
import com.example.springrecipes.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final AuthService authService;

    public List<RecipeDto> getAllRecipes() {
        return recipeRepository.findAllByOrderByCreatedDateDesc()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    private RecipeDto mapToDto(Recipe recipe) {
        return RecipeDto.builder().name(recipe.getName())
                .id(recipe.getId())
                .name(recipe.getName())
                .calories(recipe.getCalories())
                .cookTime(recipe.getCookTime())
                .directions(recipe.getDirections())
                .ingredients(recipe.getIngredients())
                .picUrl(recipe.getPicUrl())
                .servings(recipe.getServings())
                .prepTime(recipe.getPrepTime())
                .categoryId(recipe.getCategory().getId())
                .build();
    }


    public RecipeDto getRecipeById(Long id) {
        return mapToDto(recipeRepository.findById(id).orElseThrow(()->
                new RuntimeException("Recipe doesn't exist")));
    }

    public void save(RecipeDto recipeDto) {
        Recipe recipe=new Recipe();
        Category category=categoryRepository.findById(recipeDto.getCategoryId())
                .orElseThrow(()->new RuntimeException("Category doesn't exist"));
        recipe.setCategory(category);
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setPicUrl(recipeDto.getPicUrl());
        recipe.setName(recipeDto.getName());
        recipe.setDirections(recipeDto.getDirections());
        recipe.setCookTime(recipeDto.getCookTime());
        recipe.setPrepTime(recipeDto.getPrepTime());
        recipe.setServings(recipeDto.getServings());
        recipe.setCalories(recipeDto.getCalories());
        recipe.setCreatedDate(Instant.now());
        recipeRepository.save(recipe);
    }
}
