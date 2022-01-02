package p0500_;

import java.util.LinkedList;

/**
 * @author half-dead
 */
public class Puzzle227_BasicCalculatorII {
    public static void main(String[] args) {
        Solution s = new Puzzle227_BasicCalculatorII().new Solution();
        System.out.println(s.calculate(" 3 + 5 * 2 / 4 -  1 "));
        System.out.println(s.calculate("1-1+1"));
    }


    class Solution {
        public int calculate(String s) {
            LinkedList<Integer> queue = new LinkedList<>();
            int n = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') continue;

                if (Character.isDigit(c)) {
                    n *= 10;
                    n += (c - '0');
                    int next = i + 1;
                    if (next == s.length() || (next < s.length() && !Character.isDigit(s.charAt(next)))) {
                        if (queue.size() > 0 && queue.peek() < -2) {
                            int op = queue.pop();
                            int a = queue.pop();
                            n = op == -3 ? a * n : a / n;
                        }
                        queue.push(n);
                        n = 0;
                    }
                } else {
                    queue.push(c == '+' ? -1 : (c == '-' ? -2 : (c == '*' ? -3 : -4)));
                }
            }
            while (queue.size() > 1) {
                int a = queue.removeLast();
                int op = queue.removeLast();
                int b = queue.removeLast();
                queue.addLast(op < -2 ? (op == -3 ? a * b : a / b) : (op == -1 ? a + b : a - b));
            }
            return queue.pop();
        }
    }

    class Solution2 {
        public int calculate(String s) {
            int result = 0, current = 0, prev = 0;
            boolean isMul = false, isDiv = false;
            int sign = 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') continue;
                if (Character.isDigit(c)) {
                    current = current * 10 + c - '0';
                } else {
                    if (isMul) current = prev * current;
                    if (isDiv) current = prev / current;
                    isMul = false;
                    isDiv = false;

                    if (c == '+') {
                        result += current * sign;
                        sign = 1;
                    } else if (c == '-') {
                        result += current * sign;
                        sign = -1;
                    } else if (c == '*') {
                        prev = current;
                        isMul = true;
                    } else if (c == '/') {
                        prev = current;
                        isDiv = true;
                    }
                    current = 0;
                }
            }
            if (isMul) current = prev * current;
            if (isDiv) current = prev / current;
            result += current * sign;
            return result;
        }
    }
}
