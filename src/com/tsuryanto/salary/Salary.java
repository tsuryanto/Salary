package com.tsuryanto.salary;

import com.tsuryanto.salary.helpers.ErrorHandler;

import java.util.Scanner;

import static com.tsuryanto.salary.helpers.Message.ERR_INVALID_SALARY_AMOUNT;
import static com.tsuryanto.salary.helpers.Message.ERR_INVALID_SALARY_DEDUCTION_PERCENTAGE;

public class Salary {
    private Scanner reader;
    private static ErrorHandler error;
    private int salaryAmount, salaryDeductionPercentage;
    private static int numb = 1;

    public static final int SALARY_MIN = 1000;
    public static final int SALARY_MAX = 1000000;
    public static final int DEDUCTION_MIN =  0;
    public static final int DEDUCTION_MAX =  50;

    public static void main(String[] args) {
        Salary salary = new Salary();
        do {
            salary.input();
            if (salary.validate()) {
                salary.output(salary.count());
                numb++;
            }
            error.reset();
            System.out.println("\n");
        } while (salary.salaryAmount != 0 || salary.salaryDeductionPercentage != 0);
    }

    private Salary(){
        reader = new Scanner(System.in);
        error = new ErrorHandler();
    }

    private void input() {
        salaryAmount = Integer.parseInt(reader.next());
        salaryDeductionPercentage = Integer.parseInt(reader.next());
    }

    private void output(int value) {
        System.out.println("h#" + numb + ": " + value);
    }

    private boolean validate() {

        if (salaryAmount < SALARY_MIN || salaryAmount > SALARY_MAX) {
            error.showError(ERR_INVALID_SALARY_AMOUNT);
            error.setCounterUp();
        }

        if (salaryDeductionPercentage < DEDUCTION_MIN || salaryDeductionPercentage > DEDUCTION_MAX) {
            error.showError(ERR_INVALID_SALARY_DEDUCTION_PERCENTAGE);
            error.setCounterUp();
        }

        return (error.getNumbOfError() == 0);
    }

    private int count(){
        double percent = (100 - salaryDeductionPercentage) / 100.0;
        return (int) Math.ceil( (salaryAmount/percent) - salaryAmount );
    }
}
