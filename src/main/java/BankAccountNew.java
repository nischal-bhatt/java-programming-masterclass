import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccountNew {

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccountNew(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        //  synchronized(this) {
        //     balance += amount;
        // }

        //  lock.lock();
        // try{
        //     balance += amount;
        // }finally{
        //     lock.unlock();
        // }

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("could not get the lock");
            }
        } catch (InterruptedException e) {
            // do something here
        }
    }

    public void withdraw(double amount) {
        //  synchronized(this) {
        //      balance -= amount;
        //  }

        //   lock.lock();
        //   try{
        //       balance -= amount;
        //   }finally {
        //       lock.unlock();
        //   }

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("coult not get the lock");
            }
        } catch (InterruptedException e) {

        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("account number is " + this.accountNumber);
    }

    public double getBalance() {
        return balance;
    }
}