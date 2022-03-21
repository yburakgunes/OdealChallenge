package com.odeal.mapper;

import com.odeal.dto.request.CreatePaymentTypeRequestDto;
import com.odeal.dto.request.UpdatePaymentTypeRequestDto;
import com.odeal.repository.entity.PaymentType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PaymentTypeMapper {

    PaymentType fromCreate(CreatePaymentTypeRequestDto dto);
    PaymentType fromUpdate(UpdatePaymentTypeRequestDto dto);
}
