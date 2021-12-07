package ee.alex.timepass.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ee.alex.timepass.dto.PaymentDTO;
import ee.alex.timepass.entity.PaymentEntity;

@Component
public class PaymentMapper extends BaseMapper<PaymentEntity, PaymentDTO> {

    @Autowired
    public PaymentMapper() {
        super(PaymentEntity.class, PaymentDTO.class);
    }
}
