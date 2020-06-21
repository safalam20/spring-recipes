package com.example.springrecipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Email is required")
    @Email
    private String email;


    private Instant created;
    private boolean enabled;

    @ManyToMany
    private List<Category> followedCategories=new ArrayList<>();

    public void addToCategories(Category category){followedCategories.add(category);}
    @OneToMany
    private List<Recipe> myRecipes=new ArrayList<>();

    public void addCreatedRecipes(Recipe recipe){
        myRecipes.add(recipe);
    }

}
