package cl.camila;

import org.junit.Test;
import static org.junit.Assert.*;
import cl.camila.service.RecipeService;
public class RecipeServiceTest {

    @Test
    public void testMethodResultNotNull() {
        // Create an instance of the class containing the method
        RecipeService recipeService = new RecipeService();

        // Call the method and retrieve the result
        String result = recipeService.getRecipesByIngredients("banana");

        // Perform assertion to check if the result is not null
        assertNotNull(result);
    }
}
