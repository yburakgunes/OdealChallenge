package com.odeal.service;

import com.odeal.dto.request.CreateFoodRequestDto;
import com.odeal.dto.request.UpdateFoodRequestDto;
import com.odeal.exception.BadRequestException;
import com.odeal.mapper.FoodMapper;
import com.odeal.repository.IFoodRepository;
import com.odeal.repository.entity.Beverage;
import com.odeal.repository.entity.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final IFoodRepository repository;
    private final FoodMapper mapper;

    public Food saveFood(CreateFoodRequestDto dto){
        if(listAllFoods().size()-repository.findAllByAmountEquals(0).size()>=20){
            throw new BadRequestException("Unable to add new item due to capacity");
        }
        return repository.save(mapper.fromCreateFood(dto));
    }

    public Food findFoodById(long id){
        Optional<Food> foodDb = repository.findById(id);
        if(foodDb.isEmpty()){
            throw new EntityNotFoundException("Unable to find item by given id:" + id);
        }
        return foodDb.get();
    }

    public List<Food> listAllFoods(){
        return repository.findAll();
    }

    public Food updateFood(UpdateFoodRequestDto dto){
        Food food = findFoodById(dto.getId());
        food = mapper.fromUpdateFood(dto);
        food.setCreatedDate(new Date(System.currentTimeMillis()));
        return repository.save(food);
    }

    public String deleteFood(long id){
        Food food = findFoodById(id);
        repository.delete(food);
        return "Selected item has been deleted successfully";
    }

    public double calculateTotalPrice(int amount, long id){
        Food food = findFoodById(id);
        int items = food.getAmount();
        if (amount>items) {
            throw new BadRequestException("Unable to process your order. Order amount exceeds capacity");
        } food.setAmount(items-amount);
        repository.save(food);
        return (food.getPrice() * amount);
    }


}
