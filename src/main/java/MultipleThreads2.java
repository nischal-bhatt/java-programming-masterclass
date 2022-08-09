public class MultipleThreads2 {
    public static void main(String[] args) {

        CountdownGeneral countdown1 = new CountdownGeneral();
        CountdownGeneral countdown2 = new CountdownGeneral();
        CountdownThreadGeneral t1 = new CountdownThreadGeneral(countdown1);

        t1.setName("Thread 1");
        CountdownThreadGeneral t2 = new CountdownThreadGeneral(countdown2);
        t2.setName ("Thread 2");

        t1.start();
        t2.start();
    }


}

class CountdownGeneral {

    private int i;
    public void doCountdown() {
        String color;

        switch(Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color  = ThreadColor.ANSI_GREEN;

        }

        for ( i =10; i>0; i--)
        {
            //local variables are on thread stack
            //instance variables are on process heap
            System.out.println(color + Thread.currentThread().getName() + " : =" + i );
        }
    }
}


class CountdownThreadGeneral extends Thread {
    private CountdownGeneral threadCountdown;

    public CountdownThreadGeneral (CountdownGeneral countdown)
    {
        threadCountdown = countdown;
    }

    public void run () {
        threadCountdown.doCountdown();
    }
}
