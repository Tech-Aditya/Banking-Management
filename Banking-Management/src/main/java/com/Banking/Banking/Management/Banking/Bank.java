package com.Banking.Banking.Management.Banking;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class Bank  implements Account{
        private String accountHolderName;
        private Long accountNumber;
        public double balance;
        protected int age;

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("\u20B9" + amount + " Withdrawal Successfull. Current Balance: "+"\u20B9"+balance);

            } else {
                System.out.println("Insufficient Fund");
            }

        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("\u20B9" + amount +" Deposit successful. New balance: "+"\u20B9" + balance);
        }

        public void balanceChecking() {
            System.out.println("Account Balance:-> "+"\u20B9" + balance);

        }

        public void displayDetails() {
            System.out.println();
            System.out.println("Account Details:--> :)");
            System.out.println("Name: " + accountHolderName);
            System.out.println("Age: " + age);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
    }

