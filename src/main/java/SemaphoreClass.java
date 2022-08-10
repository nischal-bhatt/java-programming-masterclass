import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
    INSTANCE;

    private Semaphore semaphore = new Semaphore(5,true);

    public void download() {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }

    }

    private void downloadData() {
        try {

            System.out.println("downloading data from the web");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class SemaphoreClass {
    public static void main(String[] args) {

        ExecutorService svc = Executors.newCachedThreadPool();

        for (int i =0; i<12; i++)
        {
            svc.execute(new Runnable() {

                @Override
                public void run() {
                    Downloader.INSTANCE.download();
                }
            });
        }
    }
}
