package com.odeal.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateBeverageRequestDto {
    private long id;
    private String name;
    private int amount;
    private String type;
    private double price;
}
