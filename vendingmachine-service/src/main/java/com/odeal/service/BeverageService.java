package com.odeal.service;

import com.odeal.dto.request.CreateBeverageRequestDto;
import com.odeal.dto.request.UpdateBeverageRequestDto;
import com.odeal.exception.BadRequestException;
import com.odeal.mapper.BeverageMapper;
import com.odeal.repository.IBeverageRepository;
import com.odeal.repository.entity.Beverage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeverageService {
    private final IBeverageRepository repository;
    private final BeverageMapper mapper;

    public Beverage saveBeverage(CreateBeverageRequestDto dto){
         if (listAllBeverages().size()>=10){
             throw new BadRequestException("Unable to add new item due to capacity");
         }
        return repository.save(mapper.fromCreateBeverage(dto));
    }

    public Beverage findBeverageById(long id){
        Optional<Beverage> beverageDb= repository.findById(id);
        if(beverageDb.isEmpty()){
            throw new EntityNotFoundException("Unable to find item by given id:" + id);
        }
        return beverageDb.get();
    }

    public List<Beverage> listAllBeverages(){
        return repository.findAllByAmountGreaterThan(0);
    }

    public Beverage updateBeverage(UpdateBeverageRequestDto dto){
        Beverage beverage = findBeverageById(dto.getId());
        beverage = mapper.fromUpdateBeverage(dto);
        beverage.setCreatedDate(new Date(System.currentTimeMillis()));
        return repository.save(beverage);
    }

    public String deleteBeverage(long id ){
        Beverage beverage = findBeverageById(id);
        repository.delete(beverage);
        return "Selected item has been deleted successfully";
    }

    public double calculateTotalPrice(int amount, long id){
        Beverage beverage = findBeverageById(id);
        int items = beverage.getAmount();
        if (amount>items) {
            throw new BadRequestException("Unable to process your order. Order amount exceeds capacity");
        } beverage.setAmount(items-amount);
        repository.save(beverage);
        return (beverage.getPrice() * amount);
    }

}
