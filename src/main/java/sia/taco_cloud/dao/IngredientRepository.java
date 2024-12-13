package sia.taco_cloud.dao;



import org.springframework.data.repository.CrudRepository;

import sia.taco_cloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}