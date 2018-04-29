package com.tsuryanto.salary.helpers;

public class ErrorHandler {

    private int numbOfError;

    public void showError(String  msg){
        System.out.println("Ups, terjadi Kesalahan. " + msg);
    }

    public void setCounterUp(){
        numbOfError++;
    }

    public int getNumbOfError(){
        return numbOfError;
    }

    public void reset(){
        numbOfError = 0;
    }

}
