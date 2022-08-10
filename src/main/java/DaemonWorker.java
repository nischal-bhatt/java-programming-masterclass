class Worker implements Runnable{

    @Override
    public void run() {
        System.out.println("hello world from given thread...");
    }
}

class DaemonWorkerThread implements Runnable {

    @Override
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("daemon thread is running...");
        }
    }
}

class NormalWorkerThread implements Runnable {

    @Override
    public void run() {


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("normal thread finishes execution...");

    }
}

public class DaemonWorker {
    public static void main(String[] args) {
       // String name =Thread.currentThread().getName();
       // System.out.println(name + " is a worker thread");
        //garbage collector is a daemon thread
        //daemon run in background - low priority
        //daemon threads for i/o

        //daemon terminated by jvm when all other worker threads
        //are done

        //Thread t1 = new Thread(new Worker());
       // t1.setDaemon(true);
       // t1.start();

        Thread t1 = new Thread(new DaemonWorkerThread());
        Thread t2 = new Thread(new NormalWorkerThread());
        t1.setDaemon(true);
        t1.start();
        t2.start();
    }
}
