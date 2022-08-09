import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsMain2 {
    public static void main(String[] args) {

        List<String> someBingoNumber = Arrays.asList(

                "N40","N36","B12","B6",
                "G53","G49","G60","G50","g64",
                "I26","I17","I29","O71");

        List<String> gNums= new ArrayList<>();

        someBingoNumber.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNums.add(number);
               // System.out.println(number);
            }
        });

        gNums.sort((String s1, String s2) -> s1.compareTo(s2));

        gNums.forEach((String s ) -> System.out.println(s));
        System.out.println();
        someBingoNumber
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

    }
}
