package com.Banking.Banking.Management;
import com.Banking.Banking.Management.Banking.CurrentAccount;
import com.Banking.Banking.Management.Banking.SavingAccount;
import net.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CurrentAccountTest {

    @Test
    public void withdrawTest() {
        CurrentAccount account = new CurrentAccount("Aman Kumar", 123456789L, 29000.0, 35);
        account.withdraw(5000);
        double actual=account.balance;
        Assertions.assertEquals(24000,actual);

    }

    @Test
    public void withdrawInsufficientTest() {
        CurrentAccount account = new CurrentAccount("Aman Kumar", 123456789L, 29000.0, 35);
        account.withdraw(40000);
        double actual=account.balance;
        Assertions.assertEquals(29000,actual);

    }

    @Test
    public void withdrawalOverdraft(){
        CurrentAccount account=new CurrentAccount("Aditya",156324568L,50000,24);
        account.withdraw(59000);
        double actual=account.balance;
        Assertions.assertEquals(-9050,actual);
    }

}
