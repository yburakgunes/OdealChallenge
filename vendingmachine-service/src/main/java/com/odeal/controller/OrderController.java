package com.odeal.controller;

import com.odeal.dto.request.CreateOrderSummaryRequestDto;
import com.odeal.dto.response.GetOrderSummaryResponseDto;
import com.odeal.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/order")
public class OrderController {
    private final OrderSummaryService service;

    @PostMapping("/foodOrder/")
    public ResponseEntity<GetOrderSummaryResponseDto> foodOrderSummary(CreateOrderSummaryRequestDto dto){
       return ResponseEntity.ok((service.foodOrderSummary(dto)));
    }

    @PostMapping("/beverageOrder/")
    public ResponseEntity<GetOrderSummaryResponseDto> beverageOrderSummary(CreateOrderSummaryRequestDto dto){
        return ResponseEntity.ok((service.beverageOrderSummary(dto)));
    }




}
