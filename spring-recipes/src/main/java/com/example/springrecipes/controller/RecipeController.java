package com.example.springrecipes.controller;

import com.example.springrecipes.dto.RecipeDto;
import com.example.springrecipes.repository.RecipeRepository;
import com.example.springrecipes.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/recipes")
@AllArgsConstructor
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/allrecipes")
    public ResponseEntity<List<RecipeDto>> getAllRecipes(){
        return status(HttpStatus.OK).body(recipeService.getAllRecipes());
    }
    @GetMapping("/recipe-by-id/{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id){
        return status(HttpStatus.OK).body(recipeService.getRecipeById(id));
    }
    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody RecipeDto recipeDto) {
        recipeService.save(recipeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
