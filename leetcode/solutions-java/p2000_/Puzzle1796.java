package p2000_;

/**
 * https://leetcode.com/problems/second-largest-digit-in-a-string/
 *
 * @author half-dead
 */
public class Puzzle1796 {

    public static void main(String[] args) {
        Solution s = new Puzzle1796().new Solution();
        System.out.println(s.secondHighest("abc1111"));
    }

    class Solution {
        public int secondHighest(String s) {
            int max = '0' - 1, second = '0' - 1;
            for (char c : s.toCharArray()) {
                if (c <= '9') {
                    if (c > max) {
                        second = max;
                        max = c;
                    } else if (c != max) {
                        second = Math.max(second, c);
                    }
                }
            }
            return second < '0' ? -1 : (second - '0');
        }
    }
}
