import javafx.scene.layout.Priority;

import java.util.PriorityQueue;

/**
 * @author coolestyue
 * 要努力呀.
 */
public class PrivorityTest {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<String>(5,(a,b)->a.compareTo(b));

        queue.add("ab");
        queue.add("ac");
        String b = "aa";
        String a  = "a";

        queue.add(a);
        queue.add(b);
        System.out.println(queue.poll());

    }
}
