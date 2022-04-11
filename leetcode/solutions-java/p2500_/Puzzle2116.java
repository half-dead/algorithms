package p2500_;

/**
 * https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
 *
 * @author half-dead
 */
public class Puzzle2116 {

    class Solution {
        public boolean canBeValid(String s, String locked) {
            int n = s.length();
            if (n % 2 != 0) return false;

            int max = 0, min = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                boolean lock = locked.charAt(i) == '1';

                if (lock) {
                    if (c == '(') {
                        max++;
                        min++;
                    } else {
                        max--;
                        min--;
                        if (max < 0) return false;
                    }
                } else {
                    max++;
                    min--;
                }
                min = Math.max(min, 0);
            }
            return max >= 0 && min <= 0;
        }
    }
}
