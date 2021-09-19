/**
 * @author coolestyue
 * 要努力呀.
 */
public class TestChar1 {
    public static void main(String[] args) {
        String s = "abcdefg";
        char[] c = s.toCharArray();
        System.out.println(new String(c,1,2));
        System.out.println("24".compareTo("42"));
    }
    public void update(char[] c, int index, int a) {
        c[index] = (char) ('0' + (c[index] - '0' + a) % 10);
    }

}
