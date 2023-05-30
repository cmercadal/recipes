package cl.camila.service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import cl.camila.ApiKey;

public class RecipeService {

    static String apiKey = ApiKey.API_KEY;

    public static String getRecipesByIngredients(String ingredients) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            String url = "https://api.spoonacular.com/recipes/findByIngredients?apiKey=" + apiKey + "&ingredients=" + ingredients;
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String ingredients = "apple,onion";
        String result = getRecipesByIngredients(ingredients);
        if (result != null) {
            JSONArray recipes = new JSONArray(result);
            for (int i = 0; i < recipes.length(); i++) {
                JSONObject recipe = recipes.getJSONObject(i);
                String title = recipe.getString("title");
                int id = recipe.getInt("id");
                System.out.println("Title: " + title);
                System.out.println("ID: " + id);
                System.out.println("------------");
            }
        }
    }
}
