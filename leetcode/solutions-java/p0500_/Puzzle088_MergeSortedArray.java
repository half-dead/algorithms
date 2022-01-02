package p0500_;

// Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
// Note:
// You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
// The number of elements initialized in A and B are m and n respectively.

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Puzzle088_MergeSortedArray {
    public static void main(String[] args) {
        Puzzle088_MergeSortedArray p = new Puzzle088_MergeSortedArray();
        Solution solution = p.new Solution();
        int[] a = new int[6];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        int[] b = new int[]{2, 5, 6};
        solution.merge(a, 3, b, 3);
    }

    public class Solution {
        public void merge(int a[], int m, int b[], int n) {
            int k = m + n - 1;
            int i = m - 1, j = n - 1;
            while (i >= 0 || j >= 0) {
                if (i < 0 || (j >= 0 && a[i] <= b[j])) {
                    a[k--] = b[j--];
                } else if (k != i && (j < 0 || (i >= 0 && b[j] <= a[i]))) {
                    a[k--] = a[i--];
                } else {
                    i--;
                    k--;
                }
            }
        }
    }
}
