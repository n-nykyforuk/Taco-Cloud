package tacos.Repository;

import org.springframework.data.repository.CrudRepository;
import tacos.Entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
