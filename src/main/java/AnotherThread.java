public class AnotherThread extends Thread{

    @Override
    public void run()
    {
        System.out.println("hello from another thread");
        System.out.println("another thread ending");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("another thread woke up mup!@#");
            return;
        }
    }
}
