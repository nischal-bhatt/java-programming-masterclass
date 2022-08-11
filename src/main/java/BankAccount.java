public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;

    public BankAccount(String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    // the branch argument is true if customer is performing transaction
    // at a branch, with a teller
    // false if customer is performing trans at an atm
    public double deposit(double amount, boolean branch)
    {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch)
    {
        balance -= amount;
        return balance;
    }

    public double getBalance()
    {
        return balance;
    }


}
