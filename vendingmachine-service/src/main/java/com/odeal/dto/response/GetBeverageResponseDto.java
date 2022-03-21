package com.odeal.dto.response;

import com.odeal.repository.entity.Beverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetBeverageResponseDto {
    private long id;
    private String name;
    private int amount;
    private String type;
    private double price;

    public GetBeverageResponseDto(Beverage beverage) {
        this.id = beverage.getId();
        this.name = beverage.getName();
        this.amount = beverage.getAmount();
        this.type = beverage.getType();
        this.price = beverage.getPrice();
    }
}
