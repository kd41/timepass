package ee.alex.timepass.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseCreatedDTO extends BaseDTO {
    private static final long serialVersionUID = 4145247381856353628L;

    @NotNull
    private Date created;

    private LocalDateTime updated;

}
