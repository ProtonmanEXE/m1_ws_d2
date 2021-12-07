// Dev.: ProtonmanEXE
// Dev. Notes: 
// this is the class BankAccount for Day 2 Workshop
package workshopday2;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

public class BankAccount {
    private String name;
    private String accountNo;
    private float accountBalance;
    private List<String> transactionRecords;
    private boolean isClosed;
    private String accountCreateDate;
    private String accountCloseDate;

    // this is the "createTimeStamp" method constructor
    private String createTimeStamp() {
        SimpleDateFormat simpleDateFormat = 
                new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z"); // needs to be accompanied by
        return simpleDateFormat.format(new Date());                 // import java.text.SimpleDateFormat;
    }
    
    // this is the first constructor
    public BankAccount(String name) {
        this.name = name;
        this.accountBalance = 0f;
        this.accountNo = Integer.toString((int) (Math.random()*999999999));
        transactionRecords = new ArrayList<>();
        accountCreateDate = createTimeStamp();
        System.out.println("Account created.");
        System.out.println("Your account is " +accountNo +".");
        System.out.println("Your balance is " +accountBalance +".");
    }

    // this is the second constructor
    public BankAccount(String name, float accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.accountNo = Integer.toString((int) (Math.random()*999999999));
        transactionRecords = new ArrayList<>();
        accountCreateDate = createTimeStamp();
        System.out.println("Account created.");
        System.out.println("Your account is " +accountNo +".");
        System.out.println("Your balance is " +accountBalance +".");
    }

    // this is the "deposit" method constructor
    public void deposit(float amount) {
        boolean isNegativeAmount = 0.0 - amount > 0.001; // Fuchen's method: guarantees any value greater than 0.001 will be false

        if(isNegativeAmount == true)
            throw new IllegalArgumentException("You cannot deposit a negative value");

        else if(isClosed)
            throw new IllegalArgumentException("You cannot deposit into a closed account");

        else {
            String transaction = "Deposit $" +  amount + " at " + createTimeStamp();            
            transactionRecords.add(transaction);
            this.accountBalance += amount; // this.accountBalance = this.accountBalance + amount;
        }
    }

    // this is the "withdraw" method constructor
    public void withdraw(float amount) {
        boolean isNegativeAmount = 0.0 - amount > 0.001; // Fuchen's method: guarantees any value greater than 0.001 will be false
        boolean isGreater = amount - accountBalance > 0.001; 

        if(isNegativeAmount == true || isGreater == true)
            throw new IllegalArgumentException("You cannot cannot withdraw more than your account balance");

        else if(isClosed)
            throw new IllegalArgumentException("You cannot withdraw into a closed account");

        else {
            String transaction = "Withdraw $" +  amount + " at " + createTimeStamp();            
            transactionRecords.add(transaction);
            this.accountBalance -= amount; // this.accountBalance = this.accountBalance - amount;
        }
    }

    // I closed the following methods:
    // setName, setAccountNo, setAccountCreateDate, accountCloseDate
    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    // /**
    //  * @param name the name to set
    //  */
    // public void setName(String name) {
    //     this.name = name;
    // }

    /**
     * @return String return the accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    // /**
    //  * @param accountNo the accountNo to set
    //  */
    // public void setAccountNo(String accountNo) {
    //     this.accountNo = accountNo;
    // }

    /**
     * @return float return the accountBalance
     */
    public float getAccountBalance() {
        return accountBalance;
    }

    /**
     * @param accountBalance the accountBalance to set
     */
    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * @return List<String> return the transactions
     */
    public List<String> getTransactions() {
        return transactionRecords;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(List<String> transactions) {
        this.transactionRecords = transactions;
    }

    /**
     * @return boolean return the isClosed
     */
    public boolean isIsClosed() {
        return isClosed;
    }

    /**
     * @param isClosed the isClosed to set
     */
    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;

        if (this.isClosed == true)
            accountCloseDate = createTimeStamp();
        else
            accountCloseDate = null;
    }

    /**
     * @return String return the accountCreateDate
     */
    public String getAccountCreateDate() {
        return accountCreateDate;
    }

    // /**
    //  * @param accountCreateDate the accountCreateDate to set
    //  */
    // public void setAccountCreateDate(String accountCreateDate) {
    //     this.accountCreateDate = accountCreateDate;
    // }

    /**
     * @return String return the accountCloseDate
     */
    public String getAccountCloseDate() {
        return accountCloseDate;
    }

    // /**
    //  * @param accountCloseDate the accountCloseDate to set
    //  */
    // public void setAccountCloseDate(String accountCloseDate) {
    //     this.accountCloseDate = accountCloseDate;
    // }

}

// README
// day 2_workshop: lessons learnt/mistakes made
// 
// 1) 
// 
// day 2_workshop: techniques used
// 1) "createTimeStamp" method constructor - to generate current instant's timestamp
// 2) generate setters and getters - ctrl + shift + p
// 3) int (Math.random()*999999999) - random number generator
// 4) comparing floats - as they have very long decimal places, can use an arithmetric equation to
//                       specify the accuracy of the decimal places that you want to have (see
//                       line 53 and 74)
// 5) IllegalArgumentException - to set a specified error message that you want
// 6) super (for derived class) - used to access the parent class constructor (not methods!)
// 7) try... catch... (in my test) - to catch the exception error and give assertTrue to be True
//                                   during the test