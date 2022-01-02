package p1000_;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/shopping-offers/
 *
 * @author half-dead
 */
public class Puzzle638_ShoppingOffers {
    public static void main(String[] args) {
        Solution s = new Puzzle638_ShoppingOffers().new Solution();
        System.out.println(s.shoppingOffers(
                Arrays.asList(6, 2, 8, 6, 10, 5),
//                Arrays.asList(Arrays.asList(5, 1, 6, 2, 0, 2, 19), Arrays.asList(3, 3, 5, 3, 5, 2, 2), Arrays.asList(6, 0, 4, 3, 2, 0, 14), Arrays.asList(5, 5, 4, 1, 6, 3, 23), Arrays.asList(3, 0, 5, 2, 1, 5, 35), Arrays.asList(1, 5, 4, 3, 1, 2, 36), Arrays.asList(5, 3, 5, 4, 3, 0, 1), Arrays.asList(6, 6, 4, 2, 4, 1, 5), Arrays.asList(3, 3, 2, 6, 1, 0, 33), Arrays.asList(2, 5, 1, 2, 4, 6, 23), Arrays.asList(3, 6, 2, 6, 2, 6, 14), Arrays.asList(6, 6, 0, 3, 3, 4, 17), Arrays.asList(0, 4, 5, 3, 5, 0, 15), Arrays.asList(6, 1, 0, 6, 4, 0, 14), Arrays.asList(6, 4, 4, 3, 3, 5, 8), Arrays.asList(4, 2, 4, 3, 6, 2, 30), Arrays.asList(3, 4, 0, 3, 1, 4, 3), Arrays.asList(4, 2, 6, 3, 3, 4, 12), Arrays.asList(6, 4, 2, 5, 1, 5, 16), Arrays.asList(3, 1, 0, 0, 3, 2, 3)),
                Arrays.asList(Arrays.asList(0, 4, 5, 3, 5, 0, 15)),
                Arrays.asList(2, 4, 5, 3, 6, 3)
        ));
    }

    class Solution {
        public int shoppingOffers(List<Integer> price, List<List<Integer>> sos, List<Integer> needs) {
            int len = price.size();

            int[] res = new int[]{Integer.MAX_VALUE}, priceArray = new int[len], needsArray = new int[len];
            // copy price & needs to array for convenience
            for (int i = 0; i < len; i++) {
                priceArray[i] = price.get(i);
                needsArray[i] = needs.get(i);
            }

            dfs(priceArray, needsArray, sos, 0, 0, res);
            return res[0];
        }

        private void dfs(int[] prices, int[] needs, List<List<Integer>> sos, int idx, int cost, int[] res) {
            int len = prices.length;
            // found one possible specialoffer combination, calculate the cost
            if (idx == sos.size()) {
                for (int i = 0; i < len; i++) cost += needs[i] * prices[i];
                res[0] = Math.min(res[0], cost);
                return;
            }

            List<Integer> so = sos.get(idx);
            int offerPrice = so.get(len), maxUseTimes = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (so.get(j) > 0) maxUseTimes = Math.min(maxUseTimes, needs[j] / so.get(j));
                if (maxUseTimes == 0) break;
            }

            for (; maxUseTimes >= 0; maxUseTimes--) {
                if (maxUseTimes > 0) for (int j = 0; j < len; j++) needs[j] -= so.get(j) * maxUseTimes;

                dfs(prices, needs, sos, idx + 1, cost + maxUseTimes * offerPrice, res);

                if (maxUseTimes > 0) for (int j = 0; j < len; j++) needs[j] += so.get(j) * maxUseTimes;
            }
        }
    }

}
