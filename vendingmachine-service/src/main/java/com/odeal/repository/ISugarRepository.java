package com.odeal.repository;

import com.odeal.repository.entity.Sugar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISugarRepository extends JpaRepository<Sugar,Long> {
    Sugar findSugarByAmountGreaterThan(int number);
}
