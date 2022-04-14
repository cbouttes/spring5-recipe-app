package guru.springframework.service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

import java.util.ArrayList;

public interface RecipeService {

    RecipeRepository getRecipeRepository();

}
