package com.odeal.dto.response;

import com.odeal.dto.request.CreateOrderSummaryRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetOrderSummaryResponseDto {
    private String name;
    private int amount;
    private String nameOfPaymentType;
    private double totalPrice;
    private double change;

}
