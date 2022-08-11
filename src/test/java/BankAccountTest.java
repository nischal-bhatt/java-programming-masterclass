import static org.junit.Assert.*;

public class BankAccountTest {

    @org.junit.BeforeClass
    public static void before()
    {
        System.out.println("printing before test");
    }

    @org.junit.Test
    public void deposit() {
        BankAccount account
                = new BankAccount("Tim","Buchalka",1000.00);

        double balance = account.deposit(200.00, true);
        assertEquals(1200,account.getBalance(),0);
    }

    @org.junit.Test
    public void withdraw() {
    }

    @org.junit.Test
    public void getBalance() {
    }

    @org.junit.AfterClass
    public static void nish()
    {
        System.out.println("printing after test");
    }
}