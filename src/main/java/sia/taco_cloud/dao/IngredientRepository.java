package sia.taco_cloud.dao;

import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.taco_cloud.model.Ingredient;

@EnableCassandraRepositories
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}