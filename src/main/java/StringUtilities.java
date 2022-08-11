public class StringUtilities {

    private StringBuilder sb = new StringBuilder();

    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c)
    {
        this.sb.append(c);
        //sBuilder.append(c);
        charsAdded++;
    }
}
