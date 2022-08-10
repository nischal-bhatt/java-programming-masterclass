public class SynchronizationClass {

    public static int counter =0;

    //synchronized keyword ensures that the result is
    //deterministic
    public static synchronized void increment () {
        counter++;
    }

    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i =0; i<100; i++)
                {
                   increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i =0; i<100; i++)
                {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The counter is :" + counter);
    }

    public static void main(String[] args) throws InterruptedException {
          process();
    }
}
