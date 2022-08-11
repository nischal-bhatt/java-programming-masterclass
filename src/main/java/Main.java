public class Main {
    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();
        new Thread(()-> System.out.println("printing from runn")).start();


        doSomething a = ( r) ->  r + 25;

        System.out.println(a.getBackInteger(3));

    }
}

class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("printing from rnunable");
    }
}

@FunctionalInterface
interface doSomething {
    public int getBackInteger(int r);
}
