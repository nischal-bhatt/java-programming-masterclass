import java.util.function.Function;

public class FunctionJava8 {
    public static void main(String[] args) {
        Function<String,Integer> getStringLength =
                (String s) -> s.length();

        Function<Integer,Integer> add5 =
                (Integer r) -> r + 5;

        int r = getStringLength.andThen(add5).apply("nishbhatt");

        int q = getStringLength.apply("ordlo");


        System.out.println(r);
        System.out.println(q);
    }
}
