package com.odeal.service;

import com.odeal.dto.request.CreateSugarRequestDto;
import com.odeal.dto.request.UpdateSugarRequestDto;
import com.odeal.exception.BadRequestException;
import com.odeal.mapper.SugarMapper;
import com.odeal.repository.ISugarRepository;
import com.odeal.repository.entity.Sugar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SugarService {
    private final ISugarRepository repository;
    private final SugarMapper mapper;

    public Sugar save(CreateSugarRequestDto dto){
        return repository.save(mapper.fromCreate(dto));
    }

    public Sugar update(UpdateSugarRequestDto dto){
        return repository.save(mapper.fromUpdate(dto));
    }

    public String remainingSugar(int amount){
        Sugar sugar = repository.findSugarByAmountGreaterThan(0);
        int totalAmount = sugar.getAmount();
        if(totalAmount<amount){
            throw new BadRequestException("Requested sugar exceeds the capacity");
        } else {
            sugar.setAmount(totalAmount-amount);
            repository.save(sugar);
        }
        return "Sugar has been added";
    }
}
