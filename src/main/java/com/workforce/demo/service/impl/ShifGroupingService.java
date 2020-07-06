package com.workforce.demo.service.impl;

import com.workforce.demo.model.Shift;
import com.workforce.demo.repository.ShiftRepository;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShifGroupingService {

    @PostConstruct
    public void test() {
        boolean doesShiftBelongToGroup = doesShiftBelongToGroup("5433245", "534543");
        System.out.println(doesShiftBelongToGroup);
    }

    @Autowired
    private ShiftRepository shiftRepository;

    public boolean doesShiftBelongToGroup(String shiftCode, String shiftGroupCode) {
        Optional<Shift> findOneByCodeAndShiftGroupSet_Code = shiftRepository.findOneByCodeAndShiftGroupSet_Code(shiftCode, shiftGroupCode);
        return findOneByCodeAndShiftGroupSet_Code.isPresent();
    }

}
