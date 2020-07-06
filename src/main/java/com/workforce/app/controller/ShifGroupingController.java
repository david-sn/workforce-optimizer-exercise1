package com.workforce.app.controller;

import com.workforce.app.body.IsBelongToGroupRequestBody;
import com.workforce.app.service.impl.ShifGroupingService;
import com.workforce.app.body.IsBelongedResponse;
import com.workforce.app.template.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
public class ShifGroupingController {

    @Autowired
    private ShifGroupingService sgs;

    @RequestMapping(name = "/is-belong-to-group", method = RequestMethod.POST)
    public ResponseEntity<ResponseTemplate<IsBelongedResponse>> page(@RequestBody IsBelongToGroupRequestBody body) {
        boolean doesShiftBelongToGroup = sgs.doesShiftBelongToGroup(body.getShiftCode(), body.getShiftGroupCode());
        ResponseTemplate<IsBelongedResponse> responseTemplate = new ResponseTemplate<>("OK", "sucess", new IsBelongedResponse(doesShiftBelongToGroup));
        return new ResponseEntity<>(responseTemplate, HttpStatus.OK);
    }

}
