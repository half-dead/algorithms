package p1500_;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * @author half-dead
 */
public class Puzzle1014_CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Puzzle1014_CapacityToShipPackagesWithinDDays p = new Puzzle1014_CapacityToShipPackagesWithinDDays();
        Solution s = p.new Solution();
        System.out.println(s.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)); // 15
        System.out.println(s.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3)); // 6
        System.out.println(s.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4)); // 3
    }

    class Solution {
        public int shipWithinDays(int[] weights, int day) {
            int left = 0, right = 0;
            for (int weight : weights) {
                left = Math.max(left, weight);
                right += weight;
            }
            while (left < right) {
                int mid = (left + right) / 2, curr = 0, count = 0;
                for (int w : weights) {
                    if (curr + w > mid) {
                        count++;
                        curr = 0;
                    }
                    curr += w;
                }
                if (++count > day) left = mid + 1;
                else right = mid;
            }
            return left;
        }
    }
}
