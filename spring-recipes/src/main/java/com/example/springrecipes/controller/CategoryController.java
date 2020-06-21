package com.example.springrecipes.controller;

import com.example.springrecipes.model.Category;
import com.example.springrecipes.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/allcategories")
    public ResponseEntity<List<Category>> getCategories(){
        return status(HttpStatus.OK).body(categoryService.getAllCategories());
    }
    @GetMapping("/followed-categories")
    public ResponseEntity<List<Category>> getFollowedCategories(){
        return status(HttpStatus.OK).body(categoryService.getFollowedCategories());
    }
    @GetMapping("/follow-category/{id}")
    public ResponseEntity<Void> followCategory(@PathVariable Long id){
        categoryService.followCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/unfollow-category/{id}")
    public ResponseEntity<Void> unfollowCategory(@PathVariable Long id){
        categoryService.unfollowCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
