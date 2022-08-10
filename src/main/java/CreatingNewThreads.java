
class Runner1NewT implements Runnable{


    @Override
    public void run() {
        for (int i =0; i<10; i++)
        {
            System.out.println("Runner 1 " + i);
        }
    }
}

class Runner2NewT implements Runnable{


    @Override
    public void run() {
        for (int i =0; i<10; i++)
        {
            System.out.println("Runner 2 " + i);
        }
    }
}

public class CreatingNewThreads {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
           public void run()
           {
               for (int i =0; i<10; i++)
               {
                   System.out.println("Runner 1 " + i);
               }
           }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                for (int i =0; i<10; i++)
                {
                    System.out.println("Runner 2 " + i);
                }
            }
        });

        t1.start();
        t2.start();

    }
}
