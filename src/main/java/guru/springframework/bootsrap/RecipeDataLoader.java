package guru.springframework.bootsrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.IngredientRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Component
public class RecipeDataLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeDataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, IngredientRepository ingredientRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //INITIALIZE RECIPE GUACAMOLE
        //create ingredients for recipe Guacamole
        //ingredient avocados
        Ingredient avocados = new Ingredient();
        avocados.setDescription("avocados");
        //ingredient salt with its amount
        Ingredient oneQuarterSalt = new Ingredient();
        oneQuarterSalt.setDescription("salt");
        oneQuarterSalt.setAmount(BigDecimal.valueOf(0.25));
        //create unitOfmeasure for ingredient salt
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(teaspoon.isPresent()) {
            oneQuarterSalt.setUom(teaspoon.get());
        }
        ingredientRepository.save(oneQuarterSalt);

        Ingredient oneLemonJuice = new Ingredient();
        oneLemonJuice.setDescription("leamon juice");
        oneLemonJuice.setAmount(BigDecimal.valueOf(1));
        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(tablespoon.isPresent()) {
            oneLemonJuice.setUom(tablespoon.get());
        }
        ingredientRepository.save(oneLemonJuice);

        //create recipe Guacamole
        Recipe recipeGuacamole = new Recipe();
        recipeGuacamole.setDescription("Guacamole");
        //associate category to recipe Guacamole
        Optional<Category> categoryMexican = categoryRepository.findByDescription("Mexican");
        if (categoryMexican.isPresent()) {
            recipeGuacamole.getCategories().add(categoryMexican.get());
        }
        recipeRepository.save(recipeGuacamole);
        //associate ingredients to recipe Guacamole
        oneQuarterSalt.setRecipe(recipeGuacamole);
        ingredientRepository.save(oneQuarterSalt);
        oneLemonJuice.setRecipe(recipeGuacamole);
        ingredientRepository.save(oneLemonJuice);
        //add ingredients to recipe Guacamole
        //pas nécessaire

        //IDEM RECIPE SPICY
        //TODO create ingredients for recipe Guacamole
        Recipe recipeSpicy = new Recipe();
        recipeSpicy.setDescription("Spicy");
        //associate category to recipe Guacamole
        if (categoryMexican.isPresent()) {
            recipeSpicy.getCategories().add(categoryMexican.get());
        }
        recipeRepository.save(recipeSpicy);
        //TODO associate ingredients for recipe Spicy


    }
}
