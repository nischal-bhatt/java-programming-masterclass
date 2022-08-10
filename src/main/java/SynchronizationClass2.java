public class SynchronizationClass2 {

    public static int counter1 =0;
    public static int counter2 =0;

    //synchronized keyword ensures that the result is
    //deterministic
    /*
    problems with synchronization

    1. every object in java has an intrinsic lock
    2. thread will acquire object's intrinsic lock when it enters synchronized method
    3. no 2 threads can execute the same synchronized method at the same time
    4. problem is that every object only has a single monitor lock
    5. 2 INDEPENDENT synchronized methods, then threads
       have to wait for each other even though they are synchronized methods
6. usually it is not a good programming practise to make an entire method synchronized
     */
    public static  void increment1 () {
        synchronized(SynchronizationClass2.class) {
            counter1++;
        }
    }

    public static  void increment2 () {
        synchronized(SynchronizationClass2.class) {
            counter2++;
        }
    }

    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i =0; i<100; i++)
                {
                   increment1();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i =0; i<100; i++)
                {
                    increment2();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The counter1 is DETER:" + counter1);
        System.out.println("The counter2 is DETER:" + counter2);

       /*
       whenever first thread calls counter 1,
       it acquires the intrinsic lock of the class,
       wghich means second thread is not able to execute increment2 method!
        this will make the app slower.
        we are still dealing with time slicing, not parallel
        what we are doing in here is object level locking
        */
    }

    public static void main(String[] args) throws InterruptedException {
          process();
    }
}
