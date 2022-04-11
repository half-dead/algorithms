package p0500_;

/**
 * https://leetcode.com/problems/reverse-pairs/
 *
 * @author half-dead
 */
public class Puzzle493 {
    public static void main(String[] args) {
        Solution s = new Puzzle493().new Solution();
        int[] x = new int[]{
                0
        };
        System.out.println(s.reversePairs(x));
    }

    // merge sort solution, O(nlogn)time
    class Solution {
        int[] backup;

        public int reversePairs(int[] nums) {
            backup = new int[nums.length];
            return mergesort(nums, 0, nums.length - 1);
        }

        int mergesort(int[] arr, int start, int end) {
            if (start >= end) return 0;

            int mid = start + (end - start) / 2;
            int cnt = mergesort(arr, start, mid) + mergesort(arr, mid + 1, end);
            for (int i = start, j = mid + 1; i <= mid; i++) {
                while (j <= end && arr[i] > 2L * arr[j]) j++;
                cnt += j - (mid + 1);
            }
            merge(arr, start, mid, end);
            return cnt;
        }

        void merge(int[] arr, int start, int mid, int end) {
            System.arraycopy(arr, start, backup, start, end - start + 1);

            int i = start, j = mid + 1, k = start;
            while (i <= mid || j <= end) {
                if (i > mid || (j <= end && backup[i] > backup[j])) {
                    arr[k++] = backup[j++];
                } else {
                    arr[k++] = backup[i++];
                }
            }
        }
    }
}
