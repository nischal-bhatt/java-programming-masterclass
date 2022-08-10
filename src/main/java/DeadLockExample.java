import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException{

        DeadLockExample de = new DeadLockExample();

        new Thread(de::worker1,"worker1").start();
        new Thread(de::worker2,"worker2").start();
    }

    public void worker1 ()  {
        lock1.lock();
        System.out.println("worker 1 acquires the lock1..");
         try {
             Thread.sleep(300);
         }catch(Exception e)
         {

         }
        lock2.lock();
        System.out.println("worker 1 acquired lock2...");

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2 ()  {
        lock2.lock();
        System.out.println("worker 2 acquires the lock2..");
        try {
            Thread.sleep(300);
        } catch(Exception e)
        {

        }
        lock1.lock();
        System.out.println("worker 2 acquired lock1...");

        lock1.unlock();
        lock2.unlock();
    }
}
