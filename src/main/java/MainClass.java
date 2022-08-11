import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        List<String> someBingoNumbers =
                Arrays.asList(
                         "N40","N36","B12","B6",
                        "G53","G49","G60","G50","g64",
                        "I26","I17","I29","O71"
                );


        someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G"))
            {
                System.out.println(number);
            }
        });
        System.out.println("=====================");
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(number-> number.toUpperCase().startsWith("G"))
                .sorted()
                .forEach(System.out::println);


        Stream<String> numStread = Stream.of("A","B","C","A","D");

        numStread = numStread.distinct();
        numStread.forEach(System.out::println);


        System.out.println("===================");

        Employee john = new Employee("John Doe",30);
        Employee jane = new Employee("Jane Deer",25);
        Employee jack = new Employee("Jack Hill",40);
        Employee snow = new Employee("Snow White",22);
        Employee cena = new Employee("John cena",22);

        Department hr = new Department("hr");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        hr.addEmployee(cena);
        Department accounting = new Department ("accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .filter(department -> department.getName() == "hr")
                .flatMap(department -> department.employees().stream())
                .forEach(System.out::println);


        List<String> sortedGNums = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s-> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        for (String s : sortedGNums)
        {
            System.out.println(s);
        }


        Map<Integer,List<Employee>> groupByAge =
                departments.stream()
                        .flatMap(department -> department.employees().stream())
                        .collect(Collectors.groupingBy(employee->employee.getAge()));

        System.out.println(groupByAge);
    }
}
