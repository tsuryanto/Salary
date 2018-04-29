package com.tsuryanto.salary.helpers;

import static com.tsuryanto.salary.Salary.*;

public class Message {

    public static final String ERR_INVALID_SALARY_AMOUNT =
            "Minimal gaji adalah " + SALARY_MIN + " dan maksimal " + SALARY_MAX;

    public static final String ERR_INVALID_SALARY_DEDUCTION_PERCENTAGE =
            "Angka potongan minimal adalah " + DEDUCTION_MIN + " dan maksimal " + DEDUCTION_MAX;

}
