package com.odeal.controller;

import com.odeal.dto.request.CreateSugarRequestDto;
import com.odeal.dto.request.UpdateSugarRequestDto;
import com.odeal.dto.response.GetSugarResponseDto;
import com.odeal.service.SugarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sugar")
public class SugarController {
    private final SugarService service;

    @PostMapping("/save")
    public ResponseEntity<GetSugarResponseDto> saveSugar(CreateSugarRequestDto dto){
        return ResponseEntity.ok(new GetSugarResponseDto(service.save(dto)));
    }

    @PutMapping("/update")
    public ResponseEntity<GetSugarResponseDto> updateSugar(UpdateSugarRequestDto dto){
        return ResponseEntity.ok(new GetSugarResponseDto(service.update(dto)));
    }

    @PostMapping("/remainingSugar")
    public ResponseEntity<String> remainingSUgar(int amount){
        return ResponseEntity.ok(service.remainingSugar(amount));
    }
}
