public class BankAccount {

    private int i;
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance)
    {
        this.i = 5;
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount)
    {
synchronized(this) {
    balance += amount;
}
    }

    public void withdraw4(double amount)
    {
        synchronized(this) {
            balance -= amount;
        }
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void withdraw (double amount)
    {
       for ( i=0; i<100; i++)
       {

           balance += 1;
       }
    }

    public void withdraw2 (double amount)
    {

        for ( i=23; i<100; i++)
        {

            balance -= 1;
        }
    }
}
