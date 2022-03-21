package com.odeal.dto.response;

import com.odeal.repository.entity.Sugar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetSugarResponseDto {
    private int id;
    private int amount;

    public GetSugarResponseDto(Sugar sugar) {
        this.id = sugar.getId();
        this.amount = sugar.getAmount();
    }
}
