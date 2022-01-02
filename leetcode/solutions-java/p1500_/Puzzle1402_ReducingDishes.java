package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reducing-dishes/
 *
 * @author half-dead
 */
public class Puzzle1402_ReducingDishes {
    public static void main(String[] args) {
        Solution s = new Puzzle1402_ReducingDishes().new Solution();
        System.out.println(s.maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
    }

    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);

            int len = satisfaction.length, prev = 0;
            for (int i = 0; i < len; i++) prev += satisfaction[i] * (i + 1);

            int[] sum = new int[len + 1];
            for (int i = len - 1; i > 0; i--) sum[i] = sum[i + 1] + satisfaction[i];

            int result = Math.max(prev, 0);
            for (int i = 0; i < len; i++) {
                prev = prev - satisfaction[i] - sum[i + 1];
                result = Math.max(prev, result);
                if (satisfaction[i] >= 0) break;
            }
            return result;
        }
    }

    class Solution2 {
        public int maxSatisfaction(int[] a) {
            Arrays.sort(a);
            int res = 0, total = 0, n = a.length;
            for (int i = n - 1; i >= 0 && a[i] > -total; res += total += a[i--]) ;
            return res;
        }
    }
}
