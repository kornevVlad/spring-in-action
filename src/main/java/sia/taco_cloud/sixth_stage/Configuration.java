package sia.taco_cloud.sixth_stage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.taco_cloud.dao.IngredientRepository;
import sia.taco_cloud.dao.TacoRepository;
import sia.taco_cloud.dao.UserRepository;
import sia.taco_cloud.model.Ingredient;
import sia.taco_cloud.model.Ingredient.Type;
import sia.taco_cloud.model.Taco;

import javax.sql.DataSource;

import java.util.Arrays;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

public class Configuration {
    /**
     * ТОНКАЯ НАСТРОЙКА КОНФИГУРАЦИИ С @Bean и @Configuration
     */
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(H2)
                .addScript("taco_schema.sql")
                .addScripts("user_data.sql", "ingredient_data.sql")
                .build();
    }
}
