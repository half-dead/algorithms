package p1500_;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * @author half-dead
 */
public class Puzzle1004_MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        Puzzle1004_MaxConsecutiveOnesIII p = new Puzzle1004_MaxConsecutiveOnesIII();
        Solution s = p.new Solution();
        System.out.println(s.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(s.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    class Solution1 {
        public int longestOnes(int[] a, int k) {
            int len = a.length;
            int max = 0;
            int left = 0, right = 0, j = k;
            while (left < len && right < len) {
                while (right < len && (a[right] == 1 || j-- > 0)) {
                    right++;
                }
                max = Math.max(max, right - left);

                while (left <= right && a[left] == 1) {
                    left++;
                }
                if (left <= right && a[left] == 0 && j < k) {
                    left++;
                    j = 1;
                }
            }
            return max;
        }
    }

    class Solution {
        public int longestOnes(int[] arr, int k) {
            int left = 0;
            for (int n : arr) {
                if (n == 0)
                    k--;
                if (k < 0 && arr[left++] == 0)
                    k++;
            }
            return arr.length - left;
        }
    }
}
