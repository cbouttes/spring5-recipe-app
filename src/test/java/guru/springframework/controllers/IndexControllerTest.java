package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

public class IndexControllerTest extends TestCase {

    IndexController indexController;

    @Mock
    Model model;

    @Mock
    RecipeService recipeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testGetIndexPage() {

        //Ce qu'on veut tester :
        //Given
        //When
        //=>La méthode getIndexPage() de IndexController est appelée
        String view = indexController.getIndexPage(model);
        //Then
        //=>La méthode getRecipes() de RecipeService est appelée une fois
        verify(recipeService,times(1)).getRecipes();
        //=>La méthode addAttribute("recipes",recipeService.getRecipes()) du Model est appelée une fois
        verify(model,times(1)).addAttribute("recipes", recipeService.getRecipes());
        //=>La méthode getIndexPage() appelée plus haut renvoie un String ayant pour valeur "index"
        assertEquals("index",view);

    }
}