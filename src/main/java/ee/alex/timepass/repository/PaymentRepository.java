package ee.alex.timepass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ee.alex.timepass.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
