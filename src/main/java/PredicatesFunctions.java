import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatesFunctions {
    public static void main(String[] args) {

        String str = "abc";
        boolean match = str.equals("def");

        Predicate<String> p = qor-> qor.equals("def");

       boolean res= p.test("def");

        System.out.println(res);
        System.out.println("============================");

        List<Student> students = new ArrayList<>();
        students.add(new Student(2,3));
        students.add(new Student(3,3));
        students.add(new Student(4,3));
        students.add(new Student(5,3));

        List<Student> filtered
                = students.stream()
                //filter takes in a predicate
                .filter((Student s) -> s.getId() > 4)
                .collect(Collectors.toList());

        System.out.println(filtered);

    }
}

class Student {
    private int id;
    private int age;

    public Student(int id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}





