package p1000_;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 *
 * @author half-dead
 */
public class Puzzle678 {
    public static void main(String[] args) {
        Solution s = new Puzzle678().new Solution();
        System.out.println(s.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));

    }

    class Solution {
        public boolean checkValidString(String s) {
            int min = 0, max = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    min = Math.max(1, min + 1);
                    max++;
                } else if (c == ')') {
                    min--;
                    max--;
                } else {
                    min--;
                    max++;
                }
                if (max < 0) return false;
            }
            return min <= 0;
        }
    }

    class Solution0 {
        public boolean checkValidString(String s) {
            int lo = 0, hi = 0;
            for (char c : s.toCharArray()) {
                lo += c == '(' ? 1 : -1;
                hi += c != ')' ? 1 : -1;
                if (hi < 0) break;
                lo = Math.max(lo, 0);
            }
            return lo == 0;
        }
    }

}
