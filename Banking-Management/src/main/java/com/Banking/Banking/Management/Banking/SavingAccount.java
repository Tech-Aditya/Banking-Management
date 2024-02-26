package com.Banking.Banking.Management.Banking;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SavingAccount extends Bank {
    private double interestRate;

    public SavingAccount(String AccountHolder, Long accountNumber, double balance, int age,double interestRate) {
        super(AccountHolder, accountNumber, balance,age);
        this.interestRate = interestRate;
    }

    public double showInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest calculated: " + interest+ ", Total Amount will be:-> "+"\u20B9"+(balance+interest));
        return interest;
    }
}