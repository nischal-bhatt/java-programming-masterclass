public class BankAccountNewMain {
    public static void main(String[] args) throws InterruptedException {

        BankAccountNew acnt
                = new BankAccountNew("1234",1000);

        Thread t1 = new Thread() {
            public void run()
            {
                acnt.deposit(300.00);
                acnt.withdraw(50.00);
            }
        };

        Thread t2 = new Thread() {
            public void run()
            {
                acnt.deposit(203.75);
                acnt.withdraw(100.00);
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(acnt.getBalance());
    }
}
