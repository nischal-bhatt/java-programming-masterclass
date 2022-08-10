public class VolatileAnother {

    private static volatile int counter = 0;

    public static void main(String[] args) {
        // two threads
        // part of the same process
        // they are executing on 2 cpu cores
        // cpus will need to access the main memory

        //volatile means take from ram instead of cache

        Thread t1 = new Thread(() -> {

            int local_counter = counter;

            while (local_counter < 10)
            {
                if (local_counter != counter)
                {
                    System.out.println("[T1] local counter is changed");
                    local_counter = counter;
                }
            }
        });

        Thread t2 = new Thread(() -> {

            int local_counter = counter;

            while(local_counter<10)
            {
                System.out.println("[T2] incremented counter to " + (local_counter + 1));
                counter = ++local_counter;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
