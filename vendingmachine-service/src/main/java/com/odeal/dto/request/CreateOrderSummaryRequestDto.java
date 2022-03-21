package com.odeal.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateOrderSummaryRequestDto {
    private long id;
    private int amount;
    private long paymentId;
    private double givenMoney;
    private int sugarAmount;
}
