package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 *
 * @author half-dead
 */
public class Puzzle922_SortArrayByParityII {
    public static void main(String[] args) {
        Puzzle922_SortArrayByParityII p = new Puzzle922_SortArrayByParityII();
        Solution s = p.new Solution();
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0})));
    }

    class Solution {
        public int[] sortArrayByParityII(int[] a) {
            int e = 0, o = 1;
            for (int i = 0; i < a.length; ) {
                int isOdd = a[i] & 1;
                if (isOdd != (i & 1)) {
                    if (isOdd != 0) {
                        swap(a, i, o);
                        o += 2;
                    } else {
                        swap(a, i, e);
                        e += 2;
                    }
                } else i++;
            }
            return a;
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
