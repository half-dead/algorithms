package p0500_;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author half-dead
 */
public class Puzzle309_BestTimeToBuyAndSellStockWithColldown {

    public static void main(String[] args) {
        Solution solution = new Puzzle309_BestTimeToBuyAndSellStockWithColldown().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 4}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int[] hold = new int[]{-prices[0], -prices[0]};
            int[] cd = new int[]{0, 0};
            int[] sold = new int[]{0, 0};
            for (int i : prices) {
                int nhold0 = Math.max(hold[0], hold[1]);
                int nhold1 = Math.max(sold[0] - i, sold[1] - i);
                int ncd0 = Math.max(cd[0], cd[1]);
                int ncd1 = Math.max(hold[0] + i, hold[1] + i);
                int nsold0 = Math.max(sold[0], sold[1]);
                int nsold1 = cd[1];

                hold[0] = nhold0;
                hold[1] = nhold1;
                cd[0] = ncd0;
                cd[1] = ncd1;
                sold[0] = nsold0;
                sold[1] = nsold1;
            }
            return max(hold[0], hold[1], cd[0], cd[1], sold[0], sold[1]);
        }

        public int max(int... ints) {
            int max = ints[0];
            for (int i : ints) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        }
    }

    // TODO try to understand this sometime.
    class Solution2 {
        public int maxProfit(int[] prices) {
            int Tik0 = 0, Tik0_pre = 0, Tik1 = Integer.MIN_VALUE;
            for (int price : prices) {
                int temp = Tik0;
                Tik0 = Math.max(Tik0, Tik1 + price);
                Tik1 = Math.max(Tik1, Tik0_pre - price);
                Tik0_pre = temp;
            }
            return Tik0;
        }
    }

}
