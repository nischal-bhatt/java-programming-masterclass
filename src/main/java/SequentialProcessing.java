class Runner1 {
    public void execute () {
        for (int i =0; i<10; i++)
        {
            System.out.println("runner 1: " + i);
        }
    }
}

class Runner2 {
    public void execute () {
        for (int i =0; i<10; i++)
        {
            System.out.println("runner 2: " + i);
        }
    }
}

public class SequentialProcessing {
    public static void main(String[] args) {
        /*
        System.out.println("hello world");
        System.out.println("hello world2");
        System.out.println("hello world3");
        downloadImage();
        showImage();

         */

        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();

        runner1.execute();
        runner2.execute();
    }

    private static void showImage() {
        System.out.println("showing imnage");
    }

    private static void downloadImage() {
        System.out.println("download image");
    }
}
