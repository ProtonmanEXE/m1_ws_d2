package workshopday2;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class BankAccountTest {
    
    @Test
    public void testgetBalance() {
        BankAccount account = new BankAccount("Ian Teoh", 123.45f);
        assertTrue(account.getAccountBalance() == 123.45f);
        System.out.println("Test was a success!");
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("Maven Karoo", 12.50f);
        account.deposit(7.50f);
        assertTrue(account.getAccountBalance() == 20.00f);
        System.out.println("Test was a success!");
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("Test 3", 10.00f);
        account.withdraw(4.50f);
        assertTrue(account.getAccountBalance() == 5.50f);
        System.out.println("Test was a success!");
    }

    @Test
    public void testDepositAndWithdraw() {
        List<String> allRecords;
        BankAccount account = new BankAccount("Maven Kio");
        account.deposit(10.00f);
        account.deposit(20.00f);
        account.withdraw(30.00f);
        allRecords = account.getTransactions();
        for(int i = 0; i < allRecords.size(); i++ ) {
            System.out.println(allRecords.get(i));
        }
        assertTrue(account.getAccountBalance() == 0.00f);
        System.out.println("Test was a success!");
    }
}
