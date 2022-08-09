public class Challenge1Concurrency {
    public static void main(String[] args) throws InterruptedException {

        BankAccount acnt
                = new BankAccount("1234",1000);

/*
        Thread t1 = new Thread () {
            public void run(){
                acnt.deposit(300);
                acnt.withdraw(50);
            }
        };

        Thread t2 = new Thread () {
            public void run(){
                acnt.deposit(203.75);
                acnt.withdraw(100.00);
            }
        };

        Thread t3 = new Thread () {
            public void run(){
                acnt.deposit(400);
                acnt.withdraw(200);
            }
        };

        Thread t4 = new Thread () {
            public void run(){
                acnt.deposit(800);
                acnt.withdraw(100);
            }
        };

        Thread t5 = new Thread () {
            public void run(){
                acnt.deposit(600);
                acnt.withdraw(700);
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        /*
        t1.join();
        t2.join();
t3.join();
t4.join();
t5.join();

        System.out.println(acnt.getBalance());
  */
/*
        Thread t1 = new Thread() {
            public void run()
            {
                     acnt.withdraw(7);
            }
        };

        Thread t2 = new Thread() {
            public void run()
            {
                acnt.withdraw(7);
            }
        };

        Thread t3 = new Thread() {
            public void run()
            {
                acnt.withdraw2(7);
            }
        };

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(acnt.getBalance());
  */

        Thread thread1 = new Thread()
        {
            public void run()
            {
                acnt.deposit(300);
                acnt.withdraw4(200);
            }
        };

        Thread thread2 = new Thread()
        {
            public void run()
            {
                acnt.withdraw4(300);
                acnt.deposit(100);
            }
        };

        Thread thread3 = new Thread()
        {
            public void run()
            {
                acnt.withdraw4(200);
                acnt.deposit(300);
            }
        };

        Thread thread4 = new Thread()
        {
            public void run()
            {
                acnt.withdraw4(80);
                acnt.deposit(320);
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(acnt.getBalance());

    }
}
