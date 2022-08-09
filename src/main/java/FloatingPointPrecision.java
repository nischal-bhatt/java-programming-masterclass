public class FloatingPointPrecision {
    public static void main(String[] args) {
        int a = 5/3;
        float b  = 5f/3f;
        double c = 5d/3d;

        // java looks at a floating point number
        // and assumes its a double
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
