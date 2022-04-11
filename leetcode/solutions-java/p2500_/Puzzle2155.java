package p2500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/
 *
 * @author half-dead
 */
public class Puzzle2155 {

    class Solution {
        public List<Integer> maxScoreIndices(int[] nums) {
            int n = nums.length, ones = 0;
            for (int v : nums) {
                if (v == 1) ones++;
            }

            int max = 0;
            for (int i = 0, cnt0 = 0, cnt1 = ones; i <= n; i++) {
                int score = cnt0 + cnt1;
                max = Math.max(max, score);
                if (i == n) break;
                if (nums[i] == 0) cnt0++;
                else cnt1--;
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0, cnt0 = 0, cnt1 = ones; i <= n; i++) {
                if (cnt0 + cnt1 == max) res.add(i);
                if (i == n) break;
                if (nums[i] == 0) cnt0++;
                else cnt1--;
            }
            return res;
        }
    }
}
