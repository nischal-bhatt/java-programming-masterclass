import java.util.Random;

public class MessagesClassMain {
    public static void main(String[] args) {

        Message message = new Message();
        (new Thread (new Writer(message))).start();
        (new Thread (new Reader(message))).start();
    }
}

class Message {
    private String message;

    private boolean empty = true;

    public synchronized String read(){
        while (empty)
        {
              try{
                  wait();
              }catch (InterruptedException e)
              {

              }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message)
    {
        while (!empty)
        {

            try{
                wait();
            }catch (InterruptedException e)
            {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}


class Writer implements Runnable {

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {

        String messages[] = {
                "Humpty dumpty sat on a wall",
                "Humpty dumpty had a great fall",
                "all ths kings horses and all the kings men",
                "couldnt put humpty together again"
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try{

                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        message.write("finished");
        }
    }

    class Reader implements Runnable {
    private Message message;

       public Reader (Message message)
       {
           this.message = message;
       }

        @Override
        public void run() {

            Random random = new Random();

            for (String latestMessage = message.read(); !latestMessage.equals("finished");
                  latestMessage = message.read())

            {
                System.out.println(latestMessage+ " hi ");
                try{
                    Thread.sleep(random.nextInt(2000));
                }catch (InterruptedException e)
                {

                }
            }

        }
    }

