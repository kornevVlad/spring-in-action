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
@Table("tacos")
public class Taco {
        @PrimaryKeyColumn(type= PrimaryKeyType.PARTITIONED)
        private UUID id = Uuids.timeBased();
        @NotNull
        @Size(min = 3, message = "Поле не должно быть пустым, введите свое имя")
        private String name;

        @PrimaryKeyColumn(type=PrimaryKeyType.CLUSTERED, ordering=Ordering.DESCENDING)
        private Date createdAt = new Date();
        @Size(min = 1, message = "Выберите хотя бы один ингредиент")
        @Column("ingredients")
        private List<IngredientUDT> ingredients = new ArrayList<>();

        public void addIngredient(Ingredient ingredient) {
                this.ingredients.add(TacoUDRUtils.toIngredientUDT(ingredient));
        }
}


