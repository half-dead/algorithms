package p1500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 *
 * @author half-dead
 */
public class Puzzle1218 {

    public static void main(String[] args) {
        Solution s = new Puzzle1218().new Solution();
        System.out.println(s.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }

    class Solution {
        public int longestSubsequence(int[] arr, int d) {
            int max = 1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : arr) {
                int curr = map.getOrDefault(n - d, 0) + 1;
                map.put(n, curr);
                max = Math.max(max, curr);
            }
            return max;
        }
    }

}
