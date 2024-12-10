package sia.taco_cloud.order;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import sia.taco_cloud.model.Taco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table("Taco_Order")
public class TacoOrder {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private Date placedAt;

    @NotBlank(message = "Имя, Обязательное поле для заполнения")
    @Column("customer_name")
    private String deliveryName;

    @NotBlank(message = "Улица, Обязательное поле для заполнения")
    private String deliveryStreet;

    @NotBlank(message = "Город, Обязательное поле для заполнения")
    private String deliveryCity;

    @NotBlank(message = "Страна, Обязательное поле для заполнения")
    private String deliveryState;

    @NotBlank(message = "Индекс, Обязательное поле для заполнения")
    private String deliveryZip;

    @CreditCardNumber(message = "Неверный номер кредитной карты")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Должен быть отформатирован MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Недействительный CVV")
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
