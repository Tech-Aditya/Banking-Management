package com.Banking.Banking.Management;

import com.Banking.Banking.Management.Banking.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    public void testWithdrawal() {
        Bank bank = new Bank("Aditya", 123456789L, 10000.0, 24);
        bank.withdraw(8000.0);
        Assertions.assertEquals(2000.0, bank.balance);
    }

    @Test
    public void insufficientWithdrawalTest() {
        Bank bank = new Bank("Nagraj",15462584L,2200,25);
        bank.withdraw(2500);
        assertEquals(2200, bank.balance);
    }

    @Test
    public void testEqualWithdrawal() {
        Bank bank = new Bank("Aditya", 123456789L, 10000.0, 24);
        bank.withdraw(10000.0);
        Assertions.assertEquals(0.0, bank.balance);
    }

    @Test
    public void testDeposit() {
        Bank bank = new Bank("Suganya", 123456789L, 1000.0, 25);
        bank.deposit(500.0);
        assertEquals(1500.0, bank.balance,0);
    }

    @Test
    public void testCheckBalance() {
        Bank bank = new Bank("Aman", 123456789L, 20000.0, 30);
        double balance = bank.balance;
        Assertions.assertEquals(20000.0, bank.balance);
    }


}
