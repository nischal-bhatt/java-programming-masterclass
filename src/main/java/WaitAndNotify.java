
class Process {

     public void produce() throws InterruptedException{

         synchronized(this) {
             System.out.println("Running the produce method...");
             wait();//gives up its acquired intrinsic lock
             System.out.println("again in the produce method");
         }
     }

    public void consume() throws InterruptedException{

         Thread.sleep(1000);

         synchronized(this)
         {
             System.out.println("Consume method is executed...");
             notify(); //telling the other threads that they can now again acquire the intrinsic lock

             //not going to handle immediately - can do further operations!
         }

    }


}

public class WaitAndNotify {
    public static void main(String[] args) {
        /*
           is it possible to communicate between two threads?
           is it possible to release intrinsic lock?
           ans is yes --> wait and notify!
           threads that are locking on the same intrinsic lock can release the lock
           until the other thread calls notify

         */

        Process process  = new Process();

        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {

                try {
                    process.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){

            @Override
            public void run() {

                try {
                    process.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

    }
}
