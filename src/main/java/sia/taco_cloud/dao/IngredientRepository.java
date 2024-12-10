package sia.taco_cloud.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import sia.taco_cloud.model.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
