package lc;

import java.util.*;

/**
 * 150
 */
public class EvalRPN {


    public static int evalRPN(String[] tokens) {

        List<String> list = Arrays.asList("+", "-", "*", "/");
        Set<String> operator = new HashSet<>(list);
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // 如果是表达式. 从 栈/队列 中拿出
            if (operator.contains(token)) {
                int one = stack.pop();
                int two = stack.pop();
                int cur = 0;
                switch (token) {
                    case "+":
                        cur = one + two;
                        break;
                    case "-":
                        cur = two - one;
                        break;
                    case "*":
                        cur = one * two;
                        break;
                    case "/":
                        cur = two / one;
                        break;
                }
                stack.push(cur);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();

    }

}
