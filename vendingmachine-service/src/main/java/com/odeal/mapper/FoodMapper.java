package com.odeal.mapper;

import com.odeal.dto.request.CreateFoodRequestDto;
import com.odeal.dto.request.UpdateFoodRequestDto;
import com.odeal.repository.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FoodMapper {

    Food fromCreateFood(CreateFoodRequestDto dto);
    Food fromUpdateFood(UpdateFoodRequestDto dto);
}
