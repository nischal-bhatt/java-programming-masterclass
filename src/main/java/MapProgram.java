import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String,String> language = new HashMap<>();
        language.put("java","platform independent");
        language.put("BASIC","beginners all purposes symbolic instruction code");

        System.out.println(language.get("BASIC"));

       System.out.println( language.put("java","this course is abt java"));
        System.out.println(language.get("java"));

        if (language.containsKey("pythin"))
        {
            System.out.println("its already in the map");
        }else{
            System.out.println("adding..." +language.put("pythin","hi"));
        }
    }
}
