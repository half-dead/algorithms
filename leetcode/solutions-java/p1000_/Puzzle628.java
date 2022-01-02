package p1000_;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * @author half-dead
 */
public class Puzzle628 {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE * Integer.MAX_VALUE;
        System.out.println(a);
    }

    class Solution {
        public int maximumProduct(int[] nums) {
            int min1 = Integer.MAX_VALUE, min2 = min1, max0 = Integer.MIN_VALUE, max1 = max0, max2 = max0;
            for (int n : nums) {
                if (n <= min1) {
                    min2 = min1;
                    min1 = n;
                } else if (n <= min2) {
                    min2 = n;
                }

                if (n >= max0) {
                    max2 = max1;
                    max1 = max0;
                    max0 = n;
                } else if (n >= max1) {
                    max2 = max1;
                    max1 = n;
                } else if (n >= max2) {
                    max2 = n;
                }
            }
            return max0 * Math.max(max1 * max2, min1 < 0 && min2 < 0 ? min1 * min2 : 0);
        }
    }
}
