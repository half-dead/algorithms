package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * @author half-dead
 */
public class Puzzle315 {
    class Solution {
        int[] res;
        int[][] backup;

        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i] = new int[]{nums[i], i};
            }

            res = new int[n];
            backup = new int[n][2];

            mergesort(arr, 0, n - 1);

            List<Integer> list = new ArrayList<>(n);
            for (int x : res) list.add(x);
            return list;
        }

        void mergesort(int[][] arr, int start, int end) {
            if (start >= end) return;

            int mid = start + (end - start) / 2;
            mergesort(arr, start, mid);
            mergesort(arr, mid + 1, end);

            for (int i = start, j = mid + 1; i <= mid; i++) {
                while (j <= end && arr[i][0] > arr[j][0]) j++;
                res[arr[i][1]] += j - (mid + 1);
            }
            merge(arr, start, mid, end);
        }

        void merge(int[][] arr, int start, int mid, int end) {
            System.arraycopy(arr, start, backup, start, end + 1 - start);

            int i = start, j = mid + 1, k = start;
            while (i <= mid || j <= end) {
                if (i > mid || (j <= end && backup[i][0] > backup[j][0])) {
                    arr[k++] = backup[j++];
                } else {
                    arr[k++] = backup[i++];
                }
            }
        }
    }
}
