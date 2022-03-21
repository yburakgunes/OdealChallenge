package com.odeal.mapper;

import com.odeal.dto.request.CreateSugarRequestDto;
import com.odeal.dto.request.UpdateSugarRequestDto;
import com.odeal.repository.entity.Sugar;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SugarMapper {
    Sugar fromCreate(CreateSugarRequestDto dto);
    Sugar fromUpdate(UpdateSugarRequestDto dto);
}
