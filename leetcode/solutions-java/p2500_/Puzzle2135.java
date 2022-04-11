package p2500_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/
 *
 * @author half-dead
 */
public class Puzzle2135 {

    // bit masking, O(26N) time, O(N) space
    class Solution {
        public int wordCount(String[] startWords, String[] targetWords) {
            Set<Integer> set = new HashSet<>();
            for (String sw : startWords) {
                int code = 0;
                for (char c : sw.toCharArray()) {
                    code |= 1 << (c - 'a');
                }
                set.add(code);
            }

            int res = 0;
            for (String tw : targetWords) {
                int code = 0;
                for (char c : tw.toCharArray()) {
                    code |= 1 << (c - 'a');
                }

                for (char c : tw.toCharArray()) {
                    int mask = 1 << (c - 'a');
                    if (set.contains(code ^ mask)) {
                        res++;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
