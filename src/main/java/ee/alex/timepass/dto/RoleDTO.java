package ee.alex.timepass.dto;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO extends BaseDTO {
    private static final long serialVersionUID = -6523450813156118821L;

    @Size(min = 1, max = 25)
    private String name;

}
