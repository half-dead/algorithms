package p2000_;

/**
 * https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/
 *
 * @author half-dead
 */
public class Puzzle1849 {

    public static void main(String[] args) {
        Solution s = new Puzzle1849().new Solution();
        System.out.println(s.splitString("200100"));
    }

    class Solution {
        public boolean splitString(String s) {
            return isRemainingValid(s, -1L);
        }

        private boolean isRemainingValid(String s, long previous) {
            long current = 0;
            for (int i = 0; i < s.length(); i++) {
                current = current * 10 + s.charAt(i) - '0';

                if (current >= 10000000000L) {
                    return false;
                }
                if (previous < 0) {
                    if (isRemainingValid(s.substring(i + 1), current)) {
                        return true;
                    }
                } else if (current == previous - 1 && (i == s.length() - 1 || isRemainingValid(s.substring(i + 1), current))) {
                    return true;
                }
            }
            return false;
        }
    }
}
