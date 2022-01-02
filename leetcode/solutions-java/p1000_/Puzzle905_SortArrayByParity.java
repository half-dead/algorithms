package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 *
 * @author half-dead
 */
public class Puzzle905_SortArrayByParity {
    public static void main(String[] args) {
        Puzzle905_SortArrayByParity p = new Puzzle905_SortArrayByParity();
        Solution s = p.new Solution();
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
    }

    class Solution {
        public int[] sortArrayByParity(int[] a) {
            int i = 0, j = a.length - 1;
            while (i < j)
                if ((a[i] & 1) == 0) i++;
                else {
                    int temp = a[j];
                    a[j--] = a[i];
                    a[i] = temp;
                }
            return a;
        }
    }

    class Solution2 {
        public int[] sortArrayByParity(int[] a) {
            int[] result = new int[a.length];
            int left = 0, right = a.length - 1;
            for (int i : a)
                if ((i & 1) == 0) result[left++] = i;
                else result[right--] = i;
            return result;
        }
    }
}
