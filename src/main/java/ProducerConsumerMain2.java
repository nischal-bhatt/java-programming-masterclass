import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerMain2 {

    public static final String EOF =  "EOF";

    public static void main(String[] args) {

         List<String> buffer  = new ArrayList<String>();
         ReentrantLock bufferLock = new ReentrantLock();

         ExecutorService exec = Executors.newFixedThreadPool(3);

         MyProducer2 producer = new MyProducer2(buffer,ThreadColor.ANSI_GREEN,bufferLock);
         MyConsumer2 consumer = new MyConsumer2(buffer,ThreadColor.ANSI_PURPLE,bufferLock);
         MyConsumer2 consumer2 = new MyConsumer2(buffer,ThreadColor.ANSI_RED,bufferLock);

       exec.execute(producer) ; //new Thread(producer).start();
        exec.execute(consumer) ;
        exec.execute(consumer2) ;

        Future<String> future = exec.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_BLUE + "im being printed for the callable");
                return "this is the callable result";
            }
        });

        try{
            System.out.println(future.get());
        }catch(ExecutionException e)
        {

        }catch (InterruptedException e)
        {

        }

        exec.shutdown();

    }
}

class MyProducer2 implements Runnable {

    private List<String> buffer;
    private String color;

    private ReentrantLock bufferLock;

    public MyProducer2(List<String> buffer, String color, ReentrantLock bufferLock)
    {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {

        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};

        for (String num: nums)
        {
            try{
                System.out.println(color + "Adding...2" + num);
                    bufferLock.lock();
                    try{
                        buffer.add(num);
                    }
                    finally {
                        bufferLock.unlock();
                    }


                Thread.sleep(random.nextInt(1000));

            }catch (InterruptedException e)
            {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color  + "2Adding eof and exiting...lolo");


        bufferLock.lock();
        try{
            buffer.add("EOF");
        }finally{
            bufferLock.unlock();
        }



    }
}


class MyConsumer2 implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer2(List<String> buffer, String color,ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run()
    {
        int counter = 0;
        while (true)
        {


            if (bufferLock.tryLock())
            {
                try{
                    if (buffer.isEmpty())
                    {
                        //  bufferLock.unlock();
                        continue;
                    }

                    System.out.println(color + "2the counter =" + counter);
                    counter = 0;

                    if (buffer.get(0).equals (ProducerConsumerMain.EOF))
                    {
                        System.out.println(color + " 2Exiting ");
                        //   bufferLock.unlock();
                        break;
                    }else
                    {
                        System.out.println(color + "2Removed " + buffer.remove(0));
                    }
                }finally{
                    bufferLock.unlock();
                }
            }else{
                counter++;
            }







        }
    }
}
