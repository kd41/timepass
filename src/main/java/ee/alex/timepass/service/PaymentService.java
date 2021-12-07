package ee.alex.timepass.service;

import java.util.List;

import ee.alex.timepass.dto.PaymentDTO;
import ee.alex.timepass.dto.PaymentRequestDTO;

public interface PaymentService {

    void addPayment(PaymentRequestDTO dto);

    List<PaymentDTO> getAll();

    PaymentDTO getById(Long id) throws DataAcessException;
}
