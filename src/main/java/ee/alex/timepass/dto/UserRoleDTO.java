package ee.alex.timepass.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDTO extends BaseCreatedDTO {
    private static final long serialVersionUID = -6523450813156118821L;

    @NotNull
    private Long userId;

    @NotNull
    private Long roleId;

}
