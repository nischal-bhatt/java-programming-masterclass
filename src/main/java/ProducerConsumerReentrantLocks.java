import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class WorkerAnother {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {

        lock.lock();
        System.out.println("producer method...");
        condition.await(); //causes the current thread to wait until it is signalled
        System.out.println("again in producer method...");

        lock.unlock();
    }

    public void consume() throws InterruptedException {
          //make sure we start with producer
        Thread.sleep(2000);
        lock.lock();
        System.out.println("consumer method...");
        Thread.sleep(3000);
        condition.signal(); //wakes up the waiting thread
        lock.unlock();
    }
}


public class ProducerConsumerReentrantLocks {
    public static void main(String[] args) throws InterruptedException {

        WorkerAnother worker = new WorkerAnother();

        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                try {
                    worker.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                try {
                    worker.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
