package com.odeal.controller;

import com.odeal.dto.request.CreateFoodRequestDto;
import com.odeal.dto.request.UpdateFoodRequestDto;
import com.odeal.dto.response.GetFoodResponseDto;
import com.odeal.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/food")
public class FoodController {
    private final FoodService foodService;

    @PostMapping("/save")
    public ResponseEntity<GetFoodResponseDto> saveFood(@RequestBody CreateFoodRequestDto dto){
        return ResponseEntity.ok(new GetFoodResponseDto(foodService.saveFood(dto)));
    }

    @PutMapping("/update")
    public ResponseEntity<GetFoodResponseDto> updateFood(@RequestBody UpdateFoodRequestDto dto){
        return ResponseEntity.ok(new GetFoodResponseDto(foodService.updateFood(dto)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable long id){
        return ResponseEntity.ok(foodService.deleteFood(id));
    }

    @GetMapping("/getFood/{id}")
    public ResponseEntity<GetFoodResponseDto> getFoodById(@PathVariable long id){
        return ResponseEntity.ok(new GetFoodResponseDto(foodService.findFoodById(id)));
    }

    @GetMapping("/listAllFoods")
    public ResponseEntity<List<GetFoodResponseDto>> listAllFoods(){
        return ResponseEntity.ok().body(foodService.listAllFoods().stream().map(GetFoodResponseDto::new).collect(Collectors.toList()));
    }

}
