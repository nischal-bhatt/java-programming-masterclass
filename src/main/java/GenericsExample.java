import java.util.ArrayList;

public class GenericsExample {
    public static void main(String[] args) {

        /*
        ArrayList items = new ArrayList();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add("hello"); //no compile time error!

        print(items);
         */

        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        //a.add("nish"); // got compile time error!
        a.add(34);
        printInts(a);
    }

    private static void print(ArrayList n)
    {
        for (Object i : n)
        {
            //no compile time error!
            System.out.println((Integer) i * 2);
        }
    }

    private static void printInts(ArrayList<Integer> n)
    {
        for (Integer i : n)
        {
            System.out.println( i * 2);
        }
    }
}
