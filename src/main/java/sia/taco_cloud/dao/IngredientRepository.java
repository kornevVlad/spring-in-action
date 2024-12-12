package sia.taco_cloud.dao;


import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;

import sia.taco_cloud.model.Ingredient;

@EnableMongoRepositories
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}