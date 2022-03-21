package com.odeal.repository;

import com.odeal.repository.entity.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBeverageRepository extends JpaRepository<Beverage,Long> {
    List<Beverage> findAllByAmountGreaterThan(int amount);
}
