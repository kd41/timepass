package ee.alex.timepass.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {

    @Min(0)
    private int amount;

    @Size(min = 1, max = 25)
    private String currency;

    private String description;

    @NotNull
    private long userId;

    @NotNull
    private long courseId;
}
