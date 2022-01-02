package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 *
 * @author half-dead
 */
public class Puzzle228 {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();
            int start = 0, end = -1;
            for (int n : nums) {
                if (start > end) {
                    start = end = n;
                } else if (n == end + 1) {
                    end = n;
                } else {
                    result.add(start == end ? "" + start : start + "->" + end);
                    start = end = n;
                }
            }
            if (end >= start)
                result.add(start == end ? "" + start : start + "->" + end);
            return result;
        }
    }
}
