package sia.taco_cloud.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Long id;
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 3, message = "Поле не должно быть пустым, введите свое имя")
    private String name;

    @NotNull
    @Size(min = 1, message = "Выберите хотя бы один ингредиент")
    private List<IngredientRef> ingredients = new ArrayList<>();
}
