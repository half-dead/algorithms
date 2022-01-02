package p1000_;

/**
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 *
 * @author half-dead
 */
public class Puzzle667_BeautifulArrangementII {
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] result = new int[n];
            int left = 1, right = n;
            int i = 0;
            while (k > 1) {
                result[i++] = left++;
                result[i++] = right--;
                k -= 2;
            }
            while (left <= right) {
                if (k == 1) {
                    result[i++] = left++;
                } else {
                    result[i++] = right--;
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int[] constructArray(int n, int k) {
            int[] res = new int[n];
            int left = 1, right = n;
            for (int i = 0; i < n; i++) {
                res[i] = k % 2 == 0 ? left++ : right--;
                if (k > 1) {
                    k--;
                }
            }
            return res;
        }
    }
}
