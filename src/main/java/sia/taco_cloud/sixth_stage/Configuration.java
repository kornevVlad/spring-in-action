package sia.taco_cloud.sixth_stage;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

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
