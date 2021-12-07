// Dev.: ProtonmanEXE
// Dev. Notes: 
// this is the derived class FixedDeposit for Day 2 Workshop
package workshopday2;

public class FixedDeposit extends BankAccount {
    private float interest = 3.0f;
    private int duration = 6;
    private float accountBalance;
    private boolean isIntChanged = false;
    private boolean isDurChanged = false;

    public FixedDeposit(String name, float accountBalance) {
        super(name, accountBalance);
        this.accountBalance = accountBalance;
    }

    public FixedDeposit(String name, float accountBalance, float interest) {
        super(name, accountBalance);
        this.accountBalance = accountBalance;
    }

    public FixedDeposit(String name, float accountBalance, float interest, int duration) {
        super(name, accountBalance);
        this.accountBalance = accountBalance;
    }
    
    @Override
    public void deposit(float amount) {}

    @Override
    public void withdraw(float amount) {}

    @Override
    public float getAccountBalance() {
        this.accountBalance = accountBalance + interest*accountBalance/100;
        return accountBalance;
    }

    public void setInterest(float interest) {
        if(isIntChanged)
            throw new IllegalArgumentException("Interest has been changed before");

        this.interest = interest;
        isIntChanged = true;
    }

    public void setDurationinMonths(int duration) {
        if(isDurChanged)
            throw new IllegalArgumentException("Interest has been changed before");

        this.duration = duration;
        isDurChanged = true;
    }
}
