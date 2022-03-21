package com.odeal.repository;

import com.odeal.repository.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
