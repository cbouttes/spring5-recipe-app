package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * Return the list of recipe
     * Uri : http://localhost:8080/recipes/list
     * @param model
     * @return list of recipe
     */
    @RequestMapping("/list")
    public String recipesList(Model model){
        model.addAttribute("recipes", recipeService.getRecipeRepository().findAll());
        //recipesList is the name of the template recipesList.html and prefix recipes the directory
        return "recipes/recipesList";
    }
}
