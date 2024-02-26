package com.Banking.Banking.Management.Banking;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class CurrentAccount extends Bank {

    private int charge = 50;
    final int minimumBalance = 5000;
    @Getter
    final double overdraftLimit = 10000;

    public CurrentAccount(String AccountHolder, Long accountNumber, double balance,int age) {
        super(AccountHolder, accountNumber, balance, age);
    }

    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("\u20B9" + amount + " Withdrawal is Successful. Current Balance is:->"+"\u20B9"+balance);
            if (balance < minimumBalance) {
                balance -= charge;
                System.out.println("\u20B9" + charge + " Deducted due to Minimum Balance of "+"\u20B9"+minimumBalance);
                System.out.println("Current Balance:-> "+"\u20B9" + balance);
            }
        } else {
            System.out.println("Transaction Failed, Insufficient Fund");
        }
    }


}

































//    public void withdraw(double amount) {
//        if (balance >= amount) {
//            balance -= amount;
//            System.out.println("\u20B9" + amount + " Withdrawal is Successful. Current Balance is:->"+"\u20B9"+balance);
//            if (balance < minimumBalance) {
//                balance -= charge;
//                System.out.println("\u20B9" + charge + " Deducted due to Minimum Balance of "+"\u20B9"+minimumBalance);
//                System.out.println("Current Balance:-> "+"\u20B9" + balance);
//            }
//        } else {
//            System.out.println("Transaction Failed, Insufficient Fund");
//        }
//    }