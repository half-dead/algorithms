package p1500_;

/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 *
 * @author half-dead
 */
public class Puzzle1248 {

    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int len = nums.length, i = 0, j = 0, odd = 0, sum = 0;
            while (j < len) {
                if (nums[j] % 2 != 0) odd++;

                if (odd == k) {
                    int left = 0, right = 0;
                    while (nums[i] % 2 == 0) {
                        i++;
                        left++;
                    }
                    while (j + 1 < len && nums[j + 1] % 2 == 0) {
                        j++;
                        right++;
                    }
                    sum += (left + 1) * (right + 1);
                    i++;
                    odd--;
                }
                j++;
            }
            return sum;
        }
    }

    class Solution1 {
        public int numberOfSubarrays(int[] nums, int k) {
            int sum = 0, i = 0, count = 0;
            for (int n : nums) {
                if (n % 2 == 1) {
                    --k;
                    count = 0;
                }
                while (k == 0) {
                    k += nums[i++] & 1;
                    ++count;
                }
                sum += count;
            }
            return sum;
        }
    }

    class Solution2 {
        public int numberOfSubarrays(int[] A, int k) {
            return atMost(A, k) - atMost(A, k - 1);
        }

        public int atMost(int[] A, int k) {
            int res = 0, i = 0, n = A.length;
            for (int j = 0; j < n; j++) {
                k -= A[j] % 2;
                while (k < 0)
                    k += A[i++] % 2;
                res += j - i + 1;
            }
            return res;
        }
    }
}
