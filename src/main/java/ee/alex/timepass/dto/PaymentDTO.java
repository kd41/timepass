package ee.alex.timepass.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO extends BaseCreatedDTO {
    private static final long serialVersionUID = -2872320205518278068L;

    @Min(0)
    private int amount;

    @Size(min = 1, max = 25)
    private String currency;

    private String description;

    @NotNull
    private UserDTO user;

    @NotNull
    private CourseDTO course;
}
