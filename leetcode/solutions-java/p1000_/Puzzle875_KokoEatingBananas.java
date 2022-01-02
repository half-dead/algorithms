package p1000_;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * @author half-dead
 */
public class Puzzle875_KokoEatingBananas {
    public static void main(String[] args) {
        Puzzle875_KokoEatingBananas p = new Puzzle875_KokoEatingBananas();
        Solution s = p.new Solution();
        System.out.println(s.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(s.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(s.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(s.minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818));

    }

    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = 0;
            for (int pile : piles) right = Math.max(right, pile);
            while (left < right) {
                int mid = (left + right) / 2, count = 0;
                for (int pile : piles) count += (pile - 1) / mid + 1;
                if (count > h) left = mid + 1;
                else right = mid;
            }
            return left;
        }
    }
}
