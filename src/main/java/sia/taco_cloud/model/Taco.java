package sia.taco_cloud.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotNull
        @Size(min = 3, message = "Поле не должно быть пустым, введите свое имя")
        private String name;
        private Date createdAt = new Date();
        @Size(min = 1, message = "Выберите хотя бы один ингредиент")
        @ManyToMany()
        private List<Ingredient> ingredients = new ArrayList<>();

        public void addIngredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
        }
}


