package sia.taco_cloud.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;

@Data
public class Taco {
        @NotNull
        @Size(min = 3, message = "Поле не должно быть пустым, введите свое имя")
        private String name;

        private Date createdAt = new Date();
        @Size(min = 1, message = "Выберите хотя бы один ингредиент")
        @Column("ingredients")
        private List<Ingredient> ingredients = new ArrayList<>();

        public void addIngredient(Ingredient ingredient) {
                this.ingredients.add(ingredient);
        }
}


