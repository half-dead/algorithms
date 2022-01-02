package p2500_;

/**
 * https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
 *
 * @author half-dead
 */
public class Puzzle2042 {

    class Solution {
        public boolean areNumbersAscending(String s) {
            String[] arr = s.split(" ");
            int prev = -1;
            for (String token : arr) {
                if (token.charAt(0) > '9') continue;
                int v = Integer.parseInt(token);
                if (v <= prev) return false;
                prev = v;
            }
            return true;
        }
    }
}
