class BankAccountNew {

    private double balance;
    private String accountNumber;

    public BankAccountNew(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        synchronized(this) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        synchronized(this) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}