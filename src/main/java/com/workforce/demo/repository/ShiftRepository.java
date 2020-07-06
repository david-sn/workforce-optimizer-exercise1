package com.workforce.demo.repository;

import com.workforce.demo.model.Shift;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {

    public Optional<Shift> findOneByCodeAndShiftGroupSet_Code(String shiftCode, String shiftGroupCode);

}
