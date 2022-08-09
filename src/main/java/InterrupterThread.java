public class InterrupterThread {
    public static void main(String[] args)  {
        AnotherThread t = new AnotherThread();
        t.start();
       /* t.interrupt();*/

        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main running again");
    }
}
