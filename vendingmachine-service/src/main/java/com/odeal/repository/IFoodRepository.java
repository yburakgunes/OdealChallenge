package com.odeal.repository;

import com.odeal.repository.entity.Beverage;
import com.odeal.repository.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFoodRepository extends JpaRepository<Food,Long> {
    List<Food> findAllByAmountEquals(int amount);
}
