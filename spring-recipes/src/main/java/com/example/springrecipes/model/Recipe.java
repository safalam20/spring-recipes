package com.example.springrecipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;

    @NotBlank
    private String picUrl;

    @NotBlank
    private String prepTime;
    @NotBlank
    private String cookTime;
    @NotBlank
    private String servings;
    @NotBlank
    private String calories;

    @NotBlank
    @Lob
    private String ingredients;

    @NotBlank
    @Lob
    private String directions;

    @ManyToOne
    private Category category;

    private Instant createdDate;

    @OneToMany
    private List<Comment> comments=new ArrayList<>();

    public void addComment(Comment comment){
        comments.add(comment);
    }




}
