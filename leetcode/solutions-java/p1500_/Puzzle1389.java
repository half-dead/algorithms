package p1500_;

/**
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 *
 * @author half-dead
 */
public class Puzzle1389 {
    class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            int n = nums.length;
            int[] a = new int[n], result = new int[n];
            for (int i = 0; i < n; ++i) a[i] = i;

            helper(a, 0, n, index, new int[n]);

            for (int i = 0; i < n; ++i) result[index[i]] = nums[i];
            return result;
        }

        void helper(int[] store, int start, int end, int[] index, int[] tmp) {
            if (end - start <= 1) return;

            // recursive sort
            int mid = (start + end) / 2;
            helper(store, start, mid, index, tmp);
            helper(store, mid, end, index, tmp);

            // merge
            int x = start, y = mid, z = 0, count = 0;
            while (x < mid && y < end) {
                while (y < end && index[store[y]] <= index[store[x]] + count) {
                    ++count;
                    tmp[z++] = store[y++];
                }
                index[store[x]] += count;
                tmp[z++] = store[x++];
            }
            while (x < mid) {
                index[store[x]] += count;
                tmp[z++] = store[x++];
            }
            while (y < end) {
                tmp[z++] = store[y++];
            }
            for (int p = start, q = 0; p < end; ++p, ++q) {
                store[p] = tmp[q];
            }
        }
    }
}
