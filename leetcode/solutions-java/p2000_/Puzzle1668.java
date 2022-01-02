package p2000_;

/**
 * https://leetcode.com/problems/maximum-repeating-substring/
 *
 * @author half-dead
 */
public class Puzzle1668 {
    class Solution {
        public int maxRepeating(String sequence, String word) {
            String curr = word;
            int count = 0;
            while (sequence.contains(curr)) {
                count++;
                curr = curr + word;
            }
            return count;
        }
    }
}
