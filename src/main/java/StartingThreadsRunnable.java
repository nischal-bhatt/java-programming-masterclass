class Runner1New implements Runnable{


    @Override
    public void run() {
        for (int i =0; i<10; i++)
        {
            System.out.println("Runner 1 " + i);
        }
    }
}

class Runner2New implements Runnable{


    @Override
    public void run() {
        for (int i =0; i<10; i++)
        {
            System.out.println("Runner 2 " + i);
        }
    }
}

public class StartingThreadsRunnable {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runner1New());
        Thread t2 = new Thread(new Runner2New());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //time slicing!
        // this is not parallel execution!

    }


}
