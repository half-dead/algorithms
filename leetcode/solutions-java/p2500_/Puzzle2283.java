package p2500_;

/**
 * https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
 *
 * @author half-dead
 */
public class Puzzle2283 {

    class Solution {
        public boolean digitCount(String num) {
            int[] cnt = new int[10];
            for (char c : num.toCharArray()) {
                cnt[c - '0']++;
            }
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if ((c - '0') != cnt[i])
                    return false;
            }
            return true;
        }
    }
}
