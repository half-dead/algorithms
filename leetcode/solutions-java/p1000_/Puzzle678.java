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
            char[] cs = s.toCharArray();
            int op = 0, st = 0;
            for (int i = 0, csLength = cs.length; i < csLength; i++) {
                char c = cs[i];
                if (c == '(') {
                    op++;
                } else if (c == ')') {
                    if (op == 0 && st == 0) {
                        return false;
                    } else if (op > 0) {
                        op--;
                    } else {
                        st--;
                    }
                } else {
                    st++;
                }
            }
            return st >= op;
        }
    }


}
