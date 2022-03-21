package com.odeal.dto.response;

import com.odeal.repository.entity.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetPaymentTypeResponseDto {
    private long id;
    private String name;

    public GetPaymentTypeResponseDto(PaymentType type) {
        this.id = type.getId();
        this.name = type.getName();
    }
}
