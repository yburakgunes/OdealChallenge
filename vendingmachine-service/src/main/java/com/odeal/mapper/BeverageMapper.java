package com.odeal.mapper;

import com.odeal.dto.request.CreateBeverageRequestDto;
import com.odeal.dto.request.UpdateBeverageRequestDto;
import com.odeal.repository.entity.Beverage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BeverageMapper {

    Beverage fromCreateBeverage(CreateBeverageRequestDto dto);
    Beverage fromUpdateBeverage(UpdateBeverageRequestDto dto);
}
