package com.example.springrecipes;

import com.example.springrecipes.config.SwaggerConfiguration;
import com.example.springrecipes.model.Category;
import com.example.springrecipes.model.Recipe;
import com.example.springrecipes.model.User;
import com.example.springrecipes.repository.CategoryRepository;
import com.example.springrecipes.repository.RecipeRepository;
import com.example.springrecipes.repository.UserRepository;
import com.example.springrecipes.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;

@SpringBootApplication
@AllArgsConstructor
@Import(SwaggerConfiguration.class)
public class SpringRecipesApplication implements CommandLineRunner {

	private final AuthService authService;
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final RecipeRepository recipeRepository;
	private final CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringRecipesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Category c1=new Category();
		c1.setCategoryName("Heart & Healthy");
		categoryRepository.save(c1);

		Category c2=new Category();
		c2.setCategoryName("Quick & Easy");
		categoryRepository.save(c2);

		Category c3=new Category();
		c3.setCategoryName("Low-Calorie");
		categoryRepository.save(c3);

		Category c4=new Category();
		c4.setCategoryName("Gluten-Free");
		categoryRepository.save(c4);

		Category c5=new Category();
		c5.setCategoryName("Diabetic");
		categoryRepository.save(c5);

		Category c6=new Category();
		c6.setCategoryName("Vegetarian");
		categoryRepository.save(c6);



		Recipe r=new Recipe();
		r.setCalories("789");
		r.setCookTime("45");
		r.setIngredients("1kg ripe mixed tomatoes\n" +
				"\n" +
				", halved if small, quartered if large\n" +
				"300g day-old sourdough\n" +
				"\n" +
				" or ciabatta, torn into large chunks\n" +
				"100ml extra virgin olive oil\n" +
				"50ml red wine vinegar\n" +
				"1 small shallot\n" +
				"\n" +
				", finely chopped\n" +
				"50g tin anchovies\n" +
				"\n" +
				", drained and roughly chopped\n" +
				"100g black olives\n" +
				"\n" +
				", pitted\n" +
				"large handful of basil\n" +
				"\n" +
				" leaves, torn");
		r.setDirections("Heat the oven to 180C/160C fan/gas 4. Put the tomatoes in a colander and sprinkle over 1 tsp sea salt, then leave to sit for 15 mins. \n" +
				"\n" +
				"Spread the chunks of bread out on a baking tray and toss with 1 tbsp of the oil. Bake for 10-15 mins, or until lightly toasted. \n" +
				"\n" +
				"In a bowl, whisk together the remaining oil, the vinegar and shallot. Season to taste. Toss the anchovies with the tomatoes, croutons, olive oil dressing, the olives and half the basil in a large bowl. Spoon the panzanella onto a serving plate and top with the remaining basil.");

		r.setName("Panzanella");
		r.setPicUrl("https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe/recipe-image/2020/06/panzanella.jpg?itok=W13pKgw1");
		r.setPrepTime("60");
		r.setServings("6");
		r.setCategory(c1);
		r.setCreatedDate(Instant.now());


		recipeRepository.save(r);

		User initUser=new User();
		initUser.setCreated(Instant.now());
		initUser.setEnabled(true);
		initUser.setPassword(passwordEncoder.encode("1234"));
		initUser.setEmail("safa@gmail.com");
		initUser.setUsername("safiam");
		initUser.addToCategories(c1);
		initUser.addToCategories(c2);

		initUser.addCreatedRecipes(r);
		userRepository.save(initUser);



	}
}
