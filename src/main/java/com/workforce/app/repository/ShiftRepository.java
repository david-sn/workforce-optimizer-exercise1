package com.workforce.app.repository;

import com.workforce.app.model.Shift;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author david
 */
@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {

    public Optional<Shift> findOneByCodeAndShiftGroupSet_Code(String shiftCode, String shiftGroupCode);

}
