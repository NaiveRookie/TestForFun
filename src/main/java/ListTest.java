import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author coolestyue
 * 要努力呀.
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
        Integer index = 1;
        list.remove(index);
        System.out.println(list.toString());
    }
}
