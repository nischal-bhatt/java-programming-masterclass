public class Casting {

    public static void main(String[] args) {

        short a = 20;
        int b = 200;

        a = (short)b;

        byte c = 25;
        byte a1 =  (byte)(c/5);
        // c/ 5 automatically defaults to an int
        System.out.println(a1);

    }
}
