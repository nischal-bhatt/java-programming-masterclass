public class AnotherThread extends Thread{

    @Override
    public void run()
    {
        System.out.println("hello from another thread");
        System.out.println("another thread ending");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
