public class ClassesAndPrimitives {

    public static void main(String[] args) {
        int r = 10; //r is a primitive
        NotAPrimitive rC = new NotAPrimitive();

        rC.setX(35);
        int y = rC.add(18);
        System.out.println(y);

        //rC basically has methods that can be perofmred
        // on the data contained in it - this is a class type
        //variable and not a primitive

    }
}

class NotAPrimitive{
    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int add(int y)
    {
        return this.x + y;
    }
}
