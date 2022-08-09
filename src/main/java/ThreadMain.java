public class ThreadMain {
    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "hello from main thread");

        Thread aThread = new ColorThread();
        aThread.start();

        new Thread(){


            public void run()
            {
                System.out.println(ThreadColor.ANSI_RED + "hello from anonymous thread");

            }
        }.start();

        System.out.println(ThreadColor.ANSI_PURPLE +"hello from the main thread!");
    }
}
