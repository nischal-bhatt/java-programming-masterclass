class Runner1Sleep extends Thread{
    public void run()
    {
        for (int i =0; i<10; i++)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 1 :" + i);
        }
    }

}

class Runner2Sleep extends Thread{
    public void run()
    {
        for (int i =0; i<10; i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 2 :" + i);
        }
    }

}

public class SleepClass {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Runner1Sleep();
        Thread t2 = new Runner2Sleep();

        t1.start();
        t2.start();
        //this becomes abit more deterministic

        t1.join();
        // main thread waits for thread 1 to finish execution
        // before main thread proceeds
       // t2.join();
        System.out.println("finished with threads");
    }
}
