package p1000_;

/**
 * https://leetcode.com/problems/solve-the-equation/
 *
 * @author half-dead
 */
public class Puzzle640 {
    public static void main(String[] args) {
        Solution s = new Puzzle640().new Solution();
        System.out.println(s.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(s.solveEquation("1+1=x"));
        System.out.println(s.solveEquation("0x=0"));
    }

    class Solution {
        public String solveEquation(String equation) {
            int n = 0, co = 0, cur = 0;
            boolean left = true, negative = false;
            char[] cs = equation.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i];
                if (c >= '0' && c <= '9') {
                    cur = cur * 10 + (c - '0');
                } else {
                    if (c == 'x' && (i == 0 || cs[i - 1] < '0' || cs[i - 1] > '9')) cur = 1;
                    if (negative) cur = -cur;

                    if (c == 'x')
                        co += left ? cur : -cur;
                    else
                        n += left ? cur : -cur;

                    if (c == '=') left = false;
                    cur = 0;
                    negative = c == '-';
                }
            }
            if (cur != 0) n -= negative ? -cur : cur;

            if (co == 0)
                return n == 0 ? "Infinite solutions" : "No solution";
            else
                return "x=" + (-n) / co;
        }
    }
}
