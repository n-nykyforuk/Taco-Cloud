package tacos.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tacos.Entity.Ingredient;
import java.util.*;

@Slf4j
@Service
public class IngredientClientService {

    private final RestTemplate restTemplate;

    public IngredientClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Ingredient getIngredientById(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/ingredients/{id}",
                        Ingredient.class, ingredientId);
        log.info("Fetched time: {}",
                responseEntity.getHeaders().getDate());
        return responseEntity.getBody();

    }

    public void updateIngredient(Ingredient ingredient) {
        restTemplate.put("http://localhost:8080/ingredients/{id}",
                ingredient, ingredient.getId());
    }

    public void deleteIngredient(Ingredient ingredient) {
        restTemplate.delete("http://localhost:8080/ingredients/{id}",
                ingredient.getId());
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.postForEntity("http://localhost:8080/ingredients",
                        ingredient,
                        Ingredient.class);
        log.info("New resource created at {}",
                responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }
}
