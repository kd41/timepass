package ee.alex.timepass.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDTO implements Serializable {
    private static final long serialVersionUID = -4622720758963453019L;

    private Long id;
    private int version;

}
