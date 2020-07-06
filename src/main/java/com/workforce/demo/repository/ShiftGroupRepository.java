package com.workforce.demo.repository;

import com.workforce.demo.model.ShiftGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftGroupRepository extends JpaRepository<ShiftGroup, Integer> {

}
