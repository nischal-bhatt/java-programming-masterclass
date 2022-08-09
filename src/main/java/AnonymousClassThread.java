public class AnonymousClassThread {
    public static void main(String[] args) {

        new Thread() {
            public void run()
            {
                System.out.println("hello from anonymous thread");
            }
        }.start();
        System.out.println("hello from main thread");
    }
}
