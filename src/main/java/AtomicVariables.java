import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {

    private static /*int*/ AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        AtomicVariables a = new AtomicVariables();

        // new Thread(a::increment,"thread1").start();
       // new Thread(a::increment,"thread2").start();

      Thread t1 =   new Thread (new Runnable() {

            @Override
            public void run() {
                increment();
            }
        });

        Thread t2 =   new Thread (new Runnable() {

            @Override
            public void run() {
                increment();
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("counter : " + counter);

    }

    public static void increment() {
        for(int i =0; i<10000; i++) {
            counter.getAndIncrement();
        }
    }
}
