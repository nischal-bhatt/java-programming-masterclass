public class OtherDataTypes {
    public static void main(String[] args) {

        byte x = Byte.MAX_VALUE;
        System.out.println(x);

        x = Byte.MIN_VALUE;
        System.out.println(x);

        short y = Short.MAX_VALUE;
        System.out.println(y);

        long r = 200l;
        System.out.println(r);

        r = Long.MAX_VALUE;
        System.out.println(r);

        //long q = 2147483648;
        // this gives an error - coz by default
        // 2147483648 is seen as an int ..
        // so you must tell the compiler you meant it as a long

        long q = 2147483648l;
        // and then the compiler wont complain


        int a = 20;
        short b = 25;

        a= b;
        // an int can contain a short .. no problem
        //b = a; this will give error, coz a short, cannot contain an int!


    }
}
