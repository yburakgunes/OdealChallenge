package com.odeal.controller;

import com.odeal.dto.request.CreatePaymentTypeRequestDto;
import com.odeal.dto.request.UpdatePaymentTypeRequestDto;
import com.odeal.dto.response.GetPaymentTypeResponseDto;
import com.odeal.service.PaymentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/paymentType")
public class PaymentTypeController {
    private final PaymentTypeService service;

    @PostMapping("/save")
    public ResponseEntity<GetPaymentTypeResponseDto> savePayment(@RequestBody CreatePaymentTypeRequestDto dto){
        return ResponseEntity.ok(new GetPaymentTypeResponseDto(service.savePaymentType(dto)));
    }
    @PutMapping("/update")
    public ResponseEntity<GetPaymentTypeResponseDto> updatePayment(@RequestBody UpdatePaymentTypeRequestDto dto){
        return ResponseEntity.ok(new GetPaymentTypeResponseDto(service.updatePaymentType(dto)));
    }
    @GetMapping("/getPaymentType/{id}")
    public ResponseEntity<GetPaymentTypeResponseDto> findPaymentTypeById(@PathVariable long id){
        return ResponseEntity.ok(new GetPaymentTypeResponseDto(service.findPaymentTypeById(id)));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePaymentType(@PathVariable long id){
        return ResponseEntity.ok(service.deletePaymentType(id));
    }
    @GetMapping("/listAllPaymentTypes")
    public ResponseEntity<List<GetPaymentTypeResponseDto>> listAllPaymentTypes(){
        return ResponseEntity.ok().body(service.listAllPaymentTypes().stream().map(GetPaymentTypeResponseDto::new).collect(Collectors.toList()));
    }
}
