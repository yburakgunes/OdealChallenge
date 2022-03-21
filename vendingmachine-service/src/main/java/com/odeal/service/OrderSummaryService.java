package com.odeal.service;

import com.odeal.dto.request.CreateOrderSummaryRequestDto;
import com.odeal.dto.response.GetOrderSummaryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderSummaryService {
    private final FoodService foodService;
    private final PaymentTypeService paymentService;
    private final BeverageService beverageService;
    private final SugarService sugarService;

    public GetOrderSummaryResponseDto foodOrderSummary(CreateOrderSummaryRequestDto createDto){
        GetOrderSummaryResponseDto dto = new GetOrderSummaryResponseDto();
        sugarService.remainingSugar(createDto.getSugarAmount());
        dto.setName(foodService.findFoodById(createDto.getId()).getName());
        dto.setAmount(createDto.getAmount());
        dto.setNameOfPaymentType(paymentService.findPaymentTypeById(createDto.getPaymentId()).getName());
        dto.setTotalPrice(foodService.calculateTotalPrice(createDto.getAmount(),createDto.getId()));
        dto.setChange(createDto.getGivenMoney()-foodService.calculateTotalPrice(createDto.getAmount(),createDto.getId()));
        return dto;
    }

    public GetOrderSummaryResponseDto beverageOrderSummary(CreateOrderSummaryRequestDto createDto){
        GetOrderSummaryResponseDto dto = new GetOrderSummaryResponseDto();
        sugarService.remainingSugar(createDto.getSugarAmount());
        dto.setName(beverageService.findBeverageById(createDto.getId()).getName());
        dto.setAmount(createDto.getAmount());
        dto.setNameOfPaymentType(paymentService.findPaymentTypeById(createDto.getPaymentId()).getName());
        dto.setTotalPrice(beverageService.calculateTotalPrice(createDto.getAmount(),createDto.getId()));
        dto.setChange(createDto.getGivenMoney()-beverageService.calculateTotalPrice(createDto.getAmount(),createDto.getId()));
        return dto;
    }

}
