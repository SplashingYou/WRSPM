package com.example.mealup;

import com.spoonacular.RecipesApi;
import com.spoonacular.client.ApiClient;
import com.spoonacular.client.ApiException;
import com.spoonacular.client.Configuration;
import com.spoonacular.client.auth.ApiKeyAuth;
import com.spoonacular.client.model.AutocompleteRecipeSearch200ResponseInner;
import com.spoonacular.client.model.SearchRecipes200Response;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import static com.example.mealup.HelloApplication.API_KEY;

public class AppController {
    @FXML
    private TextField search_request_TextField;

    @FXML
    protected void onSearchClick() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.spoonacular.com");

        // Configure API key authorization: apiKeyScheme
        ApiKeyAuth apiKeyScheme = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyScheme");
        apiKeyScheme.setApiKey(API_KEY);
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyScheme.setApiKeyPrefix("Token");

        RecipesApi apiInstance = new RecipesApi(defaultClient);
        String query = search_request_TextField.getText(); // String | The (natural language) search query.
        Integer number = 10; // Integer | The maximum number of items to return (between 1 and 100). Defaults to 10.
        try {
            Set<AutocompleteRecipeSearch200ResponseInner> result = apiInstance.autocompleteRecipeSearch(query, number);
            System.out.println(result);

        } catch (ApiException e) {
            System.err.println("Exception when calling RecipesApi#autocompleteRecipeSearch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}

