package com.workforce.app.service.impl;

import com.workforce.app.model.Shift;
import com.workforce.app.model.ShiftGroup;
import com.workforce.app.repository.ShiftGroupRepository;
import com.workforce.app.repository.ShiftRepository;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
/**
 *
 * @author david
 */
@Service
public class ShifGroupingService {

    @Value("${load.seed.data}")
    private boolean loadSeedData;

    @Autowired
    private ShiftRepository shiftRepository;
    @Autowired
    private ShiftGroupRepository shiftGroupRepository;

    @PostConstruct
    private void loadData() {
        if (loadSeedData) {
            shiftRepository.deleteAll();
            shiftGroupRepository.deleteAll();
            
            Shift shift1 = new Shift("shift_code_1");
            Shift savedShift1 = shiftRepository.save(shift1);

            Shift shift2 = new Shift("shift_code_2");
            Shift savedShift2 = shiftRepository.save(shift2);

            ShiftGroup shiftGroup1 = new ShiftGroup("shift_group_1");
            ShiftGroup savedShiftGroup1 = shiftGroupRepository.save(shiftGroup1);

            ShiftGroup shiftGroup2 = new ShiftGroup("shift_group_2");
            ShiftGroup savedShiftGroup2 = shiftGroupRepository.save(shiftGroup2);

            savedShift1.getShiftGroupSet().add(savedShiftGroup1);
            savedShiftGroup1.getShiftSet().add(savedShift1);

            savedShift1.getShiftGroupSet().add(savedShiftGroup2);
            savedShiftGroup2.getShiftSet().add(savedShift1);

            savedShift2.getShiftGroupSet().add(savedShiftGroup1);
            savedShiftGroup2.getShiftSet().add(savedShift2);

//            shift2.getShiftGroupSet().add(shiftGroup2);
//            shiftGroup2.getShiftSet().add(shift2);
            shiftRepository.save(savedShift1);
            shiftRepository.save(savedShift2);

        }
    }

    public boolean doesShiftBelongToGroup(String shiftCode, String shiftGroupCode) {
        Optional<Shift> isShiftBenlongToGroup = shiftRepository.findOneByCodeAndShiftGroupSet_Code(shiftCode, shiftGroupCode);
        return isShiftBenlongToGroup.isPresent();
    }

}
