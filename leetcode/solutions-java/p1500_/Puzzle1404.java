package p1500_;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 *
 * @author half-dead
 */
public class Puzzle1404 {

    class Solution {
        public int numSteps(String s) {
            char[] cs = s.toCharArray();
            int res = 0, cnt = 0;
            for (int i = cs.length - 1, prev = '0'; i >= 0; i--) {
                if (cs[i] == prev) {
                    cnt++;
                } else {
                    res += cnt;
                    if (prev == '1') {
                        res++;
                        cs[i++] = '1';
                        cnt = 0;
                    } else {
                        prev = cs[i];
                        cnt = 1;
                    }
                }
            }
            return cnt > 1 ? (res + cnt + 1) : res;
        }
    }

    class Solution2 {
        public int numSteps(String s) {
            int res = 0, carry = 0;
            for (int i = s.length() - 1; i > 0; i--) {
                res++;
                if (s.charAt(i) - '0' + carry == 1) {
                    carry = 1;
                    res++;
                }
            }
            return res + carry;
        }
    }
}
