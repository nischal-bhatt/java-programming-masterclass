public class FloatAndDoubles {
    public static void main(String[] args) {
        //double is much more precise than float

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;

        System.out.println(myMinFloatValue);
        System.out.println(myMaxFloatValue);

        double myMinDoubleValue = Float.MIN_VALUE;
        double myMaxDoubleValue = Float.MAX_VALUE;
        //double needs 64 bits of memory
        //float needs 32 bits of memory
        System.out.println(myMinDoubleValue);
        System.out.println(myMaxDoubleValue);

        float x = 2.34f; //no error
        float y = (float)2.34; // no error

    }
}
