

import java.util.*;

/**
 * @author coolestyue
 * 要努力呀.
 */
public class TestItearor {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        String join = String.join(",", list);
        System.out.println(join);
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr2.length; i ++) {
            map.put(arr1[i], i);
        }

        return arr1;
    }

}
