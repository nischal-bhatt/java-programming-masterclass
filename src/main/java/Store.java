public class Store <T> {

    T[] list;

    public Store(T[] list) {
        this.list = list;
    }

    public void greaterThan(Store<?> otherStore)
    {
        if (list.length > otherStore.list.length)
        {
            System.out.println("true");
        }else
        {
            System.out.println("false");
        }
    }

}
