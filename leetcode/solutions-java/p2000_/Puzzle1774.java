package p2000_;

/**
 * https://leetcode.com/problems/closest-dessert-cost/
 *
 * @author half-dead
 */
public class Puzzle1774 {

    public static void main(String[] args) {
        Solution s = new Puzzle1774().new Solution();
//        System.out.println(s.closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18));
        System.out.println(s.closestCost(new int[]{3, 10}, new int[]{2, 5}, 9));
    }

    class Solution {
        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            int[] result = new int[]{baseCosts[0]};
            for (int base : baseCosts) {
                helper(toppingCosts, 0, base, target, result);
            }
            return result[0];
        }

        private void helper(int[] tps, int idx, int curr, int target, int[] holder) {
            int d1 = Math.abs(target - curr), d2 = Math.abs(target - holder[0]);
            if (d1 < d2 || d1 == d2 && curr < holder[0]) {
                holder[0] = curr;
            }
            if (idx == tps.length || curr >= target) return;
            helper(tps, idx + 1, curr, target, holder);
            helper(tps, idx + 1, curr + tps[idx], target, holder);
            helper(tps, idx + 1, curr + tps[idx] * 2, target, holder);
        }
    }
}
