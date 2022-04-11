package p2500_;

/**
 * https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
 *
 * @author half-dead
 */
public class Puzzle2124 {

    class Solution {
        public boolean checkString(String s) {
            return !s.contains("ba");
        }
    }
}
