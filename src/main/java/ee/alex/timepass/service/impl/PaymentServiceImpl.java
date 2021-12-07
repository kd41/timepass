package ee.alex.timepass.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ee.alex.timepass.common.EntityToDTOConverter;
import ee.alex.timepass.dto.PaymentDTO;
import ee.alex.timepass.dto.PaymentRequestDTO;
import ee.alex.timepass.entity.PaymentEntity;
import ee.alex.timepass.repository.CourseRepository;
import ee.alex.timepass.repository.PaymentRepository;
import ee.alex.timepass.repository.UserRepository;
import ee.alex.timepass.service.DataAcessException;
import ee.alex.timepass.service.PaymentService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final UserRepository userRepository;;
    private final CourseRepository courseRepository;

    @Override
    public void addPayment(PaymentRequestDTO dto) {
        PaymentEntity entity = new PaymentEntity();
        entity.setCreated(new Date());
        entity.setAmount(dto.getAmount());
        entity.setCurrency(dto.getCurrency());
        entity.setDescription(dto.getDescription());
        entity.setUser(userRepository.findOne(1L)); // TODO:
        entity.setCourse(courseRepository.findOne(1L)); // TODO:
        repository.save(entity);
    }

    @Override
    public List<PaymentDTO> getAll() {
        List<PaymentEntity> entities = repository.findAll();
        return EntityToDTOConverter.convertPaymentEntities(entities);
    }

    @Override
    public PaymentDTO getById(Long id) throws DataAcessException {
        PaymentEntity entity = repository.getOne(id);
        return EntityToDTOConverter.convertPaymentEntity(entity);
    }

}
