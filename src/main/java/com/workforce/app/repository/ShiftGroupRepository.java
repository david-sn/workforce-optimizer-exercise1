package com.workforce.app.repository;

import com.workforce.app.model.ShiftGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author david
 */
@Repository
public interface ShiftGroupRepository extends JpaRepository<ShiftGroup, Integer> {

}
