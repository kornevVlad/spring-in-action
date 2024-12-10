package sia.taco_cloud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Ingredient {

    @Id
    private String id;
    private String name;
    private Type type;
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}