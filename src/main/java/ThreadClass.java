public class ThreadClass {
    public static void main(String[] args) throws InterruptedException {
        //multithreading
        //1 task does not need to finish before another can start



        AnotherThread a = new AnotherThread();
        a.start(); //thread can only be started once
        Thread.sleep(3000);
        System.out.println("hello from main thread");
    }
}
