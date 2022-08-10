
class Runner1Thread extends Thread {
    public void run()
    {
        for (int i =0; i<10; i++)
        {
            System.out.println("Runner 1 " + i);
        }
    }
}

class Runner2Thread extends Thread {
    public void run()
    {
        for (int i =0; i<10; i++)
        {
            System.out.println("Runner 2 " + i);
        }
    }
}

public class ExtendingThreadClass {
    public static void main(String[] args) {

        Thread t1 = new Runner1Thread();
        Thread t2 = new Runner2Thread();

        t1.start();
        t2.start();
        //time slicing




    }
}
