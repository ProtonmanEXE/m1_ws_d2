package workshopday2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FixedDepositTest {

    @Test
    public void testDefaultInt() {
        FixedDeposit ianFixedDe = new FixedDeposit("Ian Teoh", 100.00f);
        assertTrue(ianFixedDe.getAccountBalance() == 103.00f);
        System.out.println("Test was a success!");
    }

    @Test
    public void testSetInt() {
        FixedDeposit ianFixedDe = new FixedDeposit("Ian Teoh", 100.00f);
        ianFixedDe.setInterest(10.00f);
        assertTrue(ianFixedDe.getAccountBalance() == 110.00f);
        System.out.println("Test was a success!");
    }

    @Test
    public void testSetIntTwice() {
        FixedDeposit ianFixedDe = new FixedDeposit("Ian Teoh", 200.00f);
        ianFixedDe.setInterest(10.00f);
        boolean trueOrNot = false;
        try{
            ianFixedDe.setInterest(20.00f);
        }
        catch(Exception e) {
            trueOrNot = true;
        }
        assertTrue(trueOrNot);
        System.out.println("Test was a success!");
    }

    @Test
    public void testSetDurTwice() {
        FixedDeposit ianFixedDe = new FixedDeposit("Ian Teoh", 300.00f);
        ianFixedDe.setDurationinMonths(6);
        boolean trueOrNot = false;
        try{
            ianFixedDe.setDurationinMonths(1);
        }
        catch(Exception e) {
            trueOrNot = true;
        }
        assertTrue(trueOrNot);
        System.out.println("Test was a success!");
    }

}
