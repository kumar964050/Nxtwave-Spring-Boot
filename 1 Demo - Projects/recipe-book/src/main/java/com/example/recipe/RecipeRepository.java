package com.example.recipe;

import java.util.*;
import com.example.recipe.Recipe;

public interface RecipeRepository{
    List<Recipe> getAllRecipes();
    Recipe addRecipe(Recipe newRecipe);
    Recipe getRecipeById(int recipeId);
    Recipe updateRecipe(int recipeId,Recipe newRecipe );
    void deleteRecipe(int recipeId);
}