package com.odeal.controller;

import com.odeal.dto.request.CreateBeverageRequestDto;
import com.odeal.dto.request.UpdateBeverageRequestDto;
import com.odeal.dto.response.GetBeverageResponseDto;
import com.odeal.service.BeverageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/beverage")
public class BeverageController {
    private final BeverageService beverageService;

    @PostMapping("/save")
    public ResponseEntity<GetBeverageResponseDto> saveBeverage(@RequestBody CreateBeverageRequestDto dto){
        return ResponseEntity.ok(new GetBeverageResponseDto(beverageService.saveBeverage(dto)));
    }

    @PutMapping("/update")
    public ResponseEntity<GetBeverageResponseDto> updateBeverage(@RequestBody UpdateBeverageRequestDto dto){
        return ResponseEntity.ok(new GetBeverageResponseDto(beverageService.updateBeverage(dto)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBeverage(@PathVariable long id){
        return ResponseEntity.ok(beverageService.deleteBeverage(id));
    }

    @GetMapping("/getBeverage/{id}")
    public ResponseEntity<GetBeverageResponseDto> getBeverageById(@PathVariable long id){
        return ResponseEntity.ok(new GetBeverageResponseDto(beverageService.findBeverageById(id)));
    }

    @GetMapping("/listAllBeverages")
    public ResponseEntity<List<GetBeverageResponseDto>> listAllBeverages(){
        return ResponseEntity.ok().body(beverageService.listAllBeverages().stream().map(GetBeverageResponseDto::new).collect(Collectors.toList()));
    }
}
