package p0500_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * @author half-dead
 */
public class Puzzle150_EvaluateReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            Set<String> operations = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
            LinkedList<Integer> queue = new LinkedList<>();
            for (String token : tokens) {
                if (operations.contains(token)) {
                    int b = queue.pop(), a = queue.pop();
                    int n = 0;
                    switch (token) {
                        case "+":
                            n = a + b;
                            break;
                        case "-":
                            n = a - b;
                            break;
                        case "*":
                            n = a * b;
                            break;
                        default:
                            n = a / b;
                    }
                    queue.push(n);
                } else {
                    queue.push(Integer.valueOf(token));
                }
            }
            return queue.pop();
        }
    }
}
