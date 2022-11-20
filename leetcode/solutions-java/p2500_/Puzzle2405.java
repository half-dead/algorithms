package p2500_;

/**
 * https://leetcode.com/problems/optimal-partition-of-string/
 *
 * @author half-dead
 */
public class Puzzle2405 {

    class Solution {
        public int partitionString(String s) {
            boolean[] seen = new boolean[26];
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                int p = s.charAt(i) - 'a';
                if (seen[p]) {
                    res++;
                    seen = new boolean[26];
                }
                seen[p] = true;
            }
            return res + 1;
        }
    }
}
