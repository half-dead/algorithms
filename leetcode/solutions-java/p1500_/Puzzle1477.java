package p1500_;

/**
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 *
 * @author half-dead
 */
public class Puzzle1477 {

    public static void main(String[] args) {
        Solution s = new Puzzle1477().new Solution();
        System.out.println(s.minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3));
    }

    // sliding window + dp, O(n)time, O(1)space
    class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            int[] s1 = null, s2 = null;
            int left = 0, right = 0, sum = 0, len = arr.length;
            int res = Integer.MAX_VALUE;
            while (left < len && right < len) {
                if (sum < target) sum += arr[right++];
                if (sum > target) sum -= arr[left++];

                if (sum == target) {
                    int[] cur = new int[]{left, right - 1, right - left};
                    if (s1 == null) {
                        s1 = cur;
                    } else if (s2 == null) {
                        s2 = cur;
                        if (s1[1] < s2[0] || s2[1] < s1[0]) {
                            res = Math.min(res, s1[2] + s2[2]);
                        }
                    } else {
                        if (s1[1] < cur[0]) {
                            res = Math.min(res, s1[2] + cur[2]);
                        }
                        if (s2[1] < cur[0]) {
                            res = Math.min(res, s2[2] + cur[2]);
                        }

                        // make sure s1.length >= s2.length
                        if (s2[2] >= s1[2]) {
                            int[] temp = s2;
                            s2 = s1;
                            s1 = temp;
                        }

                        // evict longest
                        if (cur[2] < s1[2]) {
                            s1 = cur;
                        }
                    }
                    sum -= arr[left++];
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
