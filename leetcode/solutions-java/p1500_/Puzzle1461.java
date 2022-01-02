package p1500_;

/**
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 *
 * @author half-dead
 */
public class Puzzle1461 {
    public static void main(String[] args) {
        Solution s = new Puzzle1461().new Solution();
        System.out.println(s.hasAllCodes("00110110", 2));
    }

    class Solution {
        public boolean hasAllCodes(String s, int k) {
            int len = s.length(), max = 1 << k;
            if (len - k + 1 < max) return false;

            char[] chars = s.toCharArray();
            boolean[] state = new boolean[max];
            int window = 0, end = -1, n = 0, comp = max / 2 - 1, cnt = 0;
            while (++end < len) {
                if (window < k) {
                    n = (n << 1) | (chars[end] - '0');
                    window++;
                }

                if (window == k) {
                    if (!state[n]) {
                        state[n] = true;
                        cnt++;
                    }
                    n &= comp;
                    window--;
                }
            }
            return cnt == max;
        }
    }
}
