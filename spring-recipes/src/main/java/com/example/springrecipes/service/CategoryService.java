package com.example.springrecipes.service;

import com.example.springrecipes.model.Category;
import com.example.springrecipes.model.User;
import com.example.springrecipes.repository.CategoryRepository;
import com.example.springrecipes.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final AuthService authService;
    private final UserRepository userRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public List<Category> getFollowedCategories() {
        return authService.getCurrentUser().getFollowedCategories();
    }
    public void followCategory(Long id) {
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Category Not Found"));
        User user=authService.getCurrentUser();
        user.addToCategories(category);
        userRepository.save(user);
    }

    public void unfollowCategory(Long id) {
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Category Not Found"));
        User user=authService.getCurrentUser();
        user.getFollowedCategories().remove(category);
        userRepository.save(user);
    }
}
