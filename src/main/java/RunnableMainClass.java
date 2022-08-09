public class RunnableMainClass {
    public static void main(String[] args) {

        Thread myRunnableThread
                = new Thread(new MyRunnable());

        myRunnableThread.start();
    }
}
