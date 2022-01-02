package p1500_;

/**
 * https://leetcode.com/problems/relative-sort-array/
 *
 * @author half-dead
 */
public class Puzzle1122_RelativeSortArray {
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int len = 1001, idx = 0;
            int[] m1 = new int[len];
            boolean[] m2 = new boolean[len];
            for (int i : arr1) m1[i]++;
            for (int i : arr2) m2[i] = true;
            for (int i : arr2) while (m1[i]-- > 0) arr1[idx++] = i;
            for (int i = 0; i < len; i++) if (m1[i] > 0 && !m2[i]) while (m1[i]-- > 0) arr1[idx++] = i;
            return arr1;
        }
    }
}
