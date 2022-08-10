

class WorkerVolatile implements Runnable {

    //it will be stored in the main memory
    private volatile boolean Terminated;

    @Override
    public void run() {
        while(!Terminated)
        {
            System.out.println("working class is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isTerminated() {
        return Terminated;
    }

    public void setTerminated(boolean terminated) {
        Terminated = terminated;
    }
}

public class VolatileKeyword {
    public static void main(String[] args) throws InterruptedException {
        /*
        thread has its own stack memory
        volatile keyword - every single read of a volatile variable will be read from the RAM and not from the cache
         */

        WorkerVolatile w = new WorkerVolatile();

        Thread t1 = new Thread(w);
        t1.start();
        Thread.sleep(3000);

        w.setTerminated(true);
        System.out.println("algorithm is terminated");
    }
}
