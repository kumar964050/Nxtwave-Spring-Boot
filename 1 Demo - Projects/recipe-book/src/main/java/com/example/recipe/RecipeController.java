package com.example.recipe;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.recipe.*;


@RestController
public class RecipeController{

    RecipeService recipeService = new RecipeService();

    // api 1
    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }
    // api 2
    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }
    // api 3
    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipeById(@PathVariable("recipeId") int recipeId){
        return recipeService.getRecipeById(recipeId);
    }
    // api 4
    @PutMapping("/recipes/{recipeId}")
    public Recipe updateRecipe(@PathVariable("recipeId") int recipeId ,@RequestBody Recipe recipe ){
        return recipeService.updateRecipe(recipeId, recipe);
    }


    // api 5
     @DeleteMapping("/recipes/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") int recipeId){
        recipeService.deleteRecipe(recipeId);
    }
}
