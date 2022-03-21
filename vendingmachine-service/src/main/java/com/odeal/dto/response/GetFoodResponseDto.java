package com.odeal.dto.response;

import com.odeal.repository.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetFoodResponseDto {
    private long id;
    private String name;
    private int amount;
    private double price;

    public GetFoodResponseDto(Food food) {
        this.id = food.getId();
        this.name = food.getName();
        this.amount = food.getAmount();
        this.price = food.getPrice();
    }
}
