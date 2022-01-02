package p1000_;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/fair-candy-swap/
 *
 * @author half-dead
 */
public class Puzzle888_FairCandySwap {
    public static void main(String[] args) {
        Puzzle888_FairCandySwap p = new Puzzle888_FairCandySwap();
        Solution s = p.new Solution();
        int[] ints = s.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4});
        System.out.println(Arrays.toString(ints));
    }

    class Solution {
        public int[] fairCandySwap(int[] a, int[] b) {
            int sumA = 0, sumB = 0;
            for (int i : a) {
                sumA += i;
            }
            for (int i : b) {
                sumB += i;
            }
            int dif = (sumA - sumB) / 2;
            HashSet<Integer> set = new HashSet<>();
            for (int n : a) {
                set.add(n);
            }
            for (int n : b) {
                if (set.contains(n + dif)) {
                    return new int[]{n + dif, n};
                }
            }
            return null;
        }
    }

}
