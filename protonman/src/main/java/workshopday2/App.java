package workshopday2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BankAccount ianAccount = new BankAccount("Ian");
        ianAccount.deposit(100.0f);
        ianAccount.deposit(101.0f);
        ianAccount.withdraw(201.0f);
        float printout = ianAccount.getAccountBalance();
        System.out.println(printout);

        FixedDeposit ianFixedDe = new FixedDeposit(ianAccount.getName(), ianAccount.getAccountBalance());
        ianFixedDe.deposit(100.0f);
    }
}
