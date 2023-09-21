package com.example.recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.recipe.RecipeRepository;
import com.example.recipe.Recipe;


import java.util.*;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();
        private int unqId = 6;

        public RecipeService() {
                recipeBook.put(1,
                                new Recipe(1, "Pasta", "veg",
                                                Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        // Don't modify the above code

        // Write your code here
        @Override
        public List<Recipe> getAllRecipes(){
                Collection<Recipe> resCollection = recipeBook.values();
                List<Recipe> resList = new ArrayList<>(resCollection);

                return resList;
        }

        @Override
        public Recipe addRecipe(Recipe newRecipe){
                newRecipe.setRecipeId(unqId);
                recipeBook.put(unqId,newRecipe);
                unqId +=1;
                return newRecipe;
        }
        @Override
        public Recipe getRecipeById(int recipeId){
                Recipe findRes = recipeBook.get(recipeId);
                if(findRes == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                return findRes;
        }

        @Override
        public Recipe updateRecipe(int recipeId,Recipe newRecipe ){
                Recipe findRes = recipeBook.get(recipeId);
                if(findRes == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                if(newRecipe.getRecipeName() != null) findRes.setRecipeName(newRecipe.getRecipeName());
                if(newRecipe.getRecipeType() != null) findRes.setRecipeType(newRecipe.getRecipeType());
                if(newRecipe.getIngredients() != null) findRes.setIngredients(newRecipe.getIngredients());
                return findRes;
        }

        @Override
        public void deleteRecipe(int recipeId){
                Recipe findRes = recipeBook.get(recipeId);
                if(findRes == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                else{
                        recipeBook.remove(recipeId);
                        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }

        }
}