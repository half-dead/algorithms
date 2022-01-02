package p1000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/fraction-addition-and-subtraction/
 *
 * @author half-dead
 */
public class Puzzle592_FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        Puzzle592_FractionAdditionAndSubtraction p = new Puzzle592_FractionAdditionAndSubtraction();
        Solution s = p.new Solution();
        System.out.println(s.fractionAddition("-4/7-3/4+2/3"));
    }

    class Solution {
        public String fractionAddition(String exp) {
            int numerator = 0, denominator = 1;
            boolean plus = true;
            int n = 0;
            LinkedList<Integer> stack = new LinkedList<>();
            stack.push(0);
            for (int i = 0; i < exp.length(); i++) {
                char c = exp.charAt(i);
                if (c == '-') {
                    plus = false;
                } else if (c == '+') {
                    plus = true;
                } else if (c == '/') {
                    stack.push(n);
                    n = 0;
                } else {
                    int j = c - '0';
                    n *= 10;
                    n += j;
                }
                int nextIndex = i + 1;
                if ((nextIndex < exp.length() && (exp.charAt(nextIndex) == '-' || exp.charAt(nextIndex) == '+'))
                        || nextIndex == exp.length()) {
                    int[] res = cal(numerator, denominator, stack.pop(), n == 0 ? 1 : n, plus);
                    numerator = res[0];
                    denominator = res[1];
                    n = 0;
                }
            }

            return numerator + "/" + denominator;
        }

        private int gcd(int a, int b) {
            return (a == 0 || b == 0) ? a + b : gcd(b, a % b);
        }

        private int[] cal(int a1, int b1, int a2, int b2, boolean plus) {
            int a = plus ? (a1 * b2 + b1 * a2) : (a1 * b2 - b1 * a2);
            int b = b1 * b2;
            int gcd = gcd(Math.abs(a), b);
            return new int[]{a / gcd, b / gcd};
        }
    }
}
