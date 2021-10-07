package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author coolestyue
 * 要努力呀.
 */
public class Leetcode394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        Stack<Character> charStack = new Stack<>();
        Queue queue = new LinkedList();
    }
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> charStack = new Stack<>();
        Stack<Integer> multiStack = new Stack<>();
        int multi = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            } else if (c == '[') {
                multiStack.push(multi);
                multi = 0;
                charStack.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int curMulti = multiStack.pop();
                for (int i = 0; i < curMulti; i ++) temp.append(res.toString());

                res = new StringBuilder(charStack.pop() + temp);

            } else {

                res.append(c);

            }
        }
        return res.toString();

    }
}
