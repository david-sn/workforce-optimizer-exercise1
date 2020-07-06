package com.workforce.app.body;

/**
 *
 * @author david
 */
public class IsBelongToGroupRequestBody {

    private String shiftCode;
    private String shiftGroupCode;

    public IsBelongToGroupRequestBody() {
    }

    public String getShiftCode() {
        return shiftCode;
    }

    public void setShiftCode(String shiftCode) {
        this.shiftCode = shiftCode;
    }

    public String getShiftGroupCode() {
        return shiftGroupCode;
    }

    public void setShiftGroupCode(String shiftGroupCode) {
        this.shiftGroupCode = shiftGroupCode;
    }

}
