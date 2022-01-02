package p1500_;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * @author half-dead
 */
public class Puzzle1423 {

    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int len = cardPoints.length, sum = 0;
            for (int i = 0; i < k; i++) {
                sum += cardPoints[i];
            }

            int ans = sum, i = len - 1;
            if (k == len) return ans;
            while (--k >= 0) {
                sum = sum - cardPoints[k] + cardPoints[i--];
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }
}
