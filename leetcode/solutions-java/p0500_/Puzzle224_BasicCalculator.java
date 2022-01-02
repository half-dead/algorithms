package p0500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/basic-calculator/
 *
 * @author half-dead
 */
public class Puzzle224_BasicCalculator {

    public static void main(String[] args) {
        Puzzle224_BasicCalculator p = new Puzzle224_BasicCalculator();
        Solution s = p.new Solution();
//        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
//        System.out.println(s.calculate(" (1 + 1 )"));
        System.out.println(s.calculate(" 2-1+ 2"));
    }

    class Solution {
        public int calculate(String s) {
            int num = 0;
            LinkedList<LinkedList<Integer>> queue = new LinkedList<>();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') continue;

                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                    int next = i + 1;
                    if (next == s.length() || (next < s.length() && !Character.isDigit(s.charAt(next)))) {
                        level.push(num);
                        num = 0;
                    }
                } else {
                    if (c == '+') {
                        level.push(-1);
                    } else if (c == '-') {
                        level.push(-2);
                    } else if (c == '(') {
                        queue.push(level);
                        level = new LinkedList<>();
                    } else {
                        int res = cal(level);
                        level = queue.pop();
                        level.push(res);
                    }
                }
            }
            return cal(level);
        }

        private int cal(LinkedList<Integer> q) {
            while (q.size() > 1) {
                int a = q.removeLast(), op = q.removeLast(), b = q.removeLast();
                q.addLast(op == -1 ? a + b : a - b);
            }
            return q.pop();
        }
    }
}
